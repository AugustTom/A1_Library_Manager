package tawelib;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Class.*;

public class Conn {

    /**
     * Takes a prepared statement and a list of objects to bind to it, and returns the prepared statement with objects bound
     * @param prepStmt the prepared statement of the sql string and connection
     * @param binds the arraylist of variables to be binded to the prepared statement (Currently only accepts, strings, doubles and ints)
     * @return the binded prepared statement
     */
    private static PreparedStatement bindPreparedStatement(PreparedStatement prepStmt,ArrayList<Object> binds) {

        try {

            //For every element in the arraylist, check its type and add it to the prepared statement with the correct type
            for (int i = 0; i < binds.size(); i++) {
                if (binds.get(i) instanceof Double) {
                    prepStmt.setDouble(i+1,(Double)binds.get(i));
                    //System.out.println("Double" + binds.get(i));
                } else if (binds.get(i) instanceof Integer) {
                    prepStmt.setInt(i+1,(int)binds.get(i));
                    //System.out.println("Int" + binds.get(i));
                } else {
                    prepStmt.setString(i+1,(String)binds.get(i));
                    //System.out.println("String" + binds.get(i));
                }
            }

            return prepStmt;

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error preparing statement");
        }

        return null;

    }

    //Reading

    private static ResultSet runQuery(String sql,ArrayList<Object> binds) {

        try {
            Connection con = null;
           //Class.forName("com.mysql.jdbc.Driver");

            try {
               con = DriverManager
                        .getConnection("jdbc:mysql://localhost:8080/cs230library","root", "");

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }

            System.out.println("Con is" + con);
            PreparedStatement prepStmt = con.prepareStatement(sql);
            prepStmt = bindPreparedStatement(prepStmt,binds);

            return prepStmt.executeQuery();

        } catch ( SQLException err ) {
            System.out.println(err.getMessage() + "Error executing query");
        }
        return null;

    }

    private static ArrayList<Integer> getCopies(int id) {

        try {

            final String sql = "SELECT copy_id FROM `copy` WHERE resource_ID = ?";

            ArrayList binds = new ArrayList();
            binds.add(id);

            ResultSet rs = runQuery(sql,binds);
            ArrayList<Integer> copies = new ArrayList<>();

            while (rs.next()) {
                copies.add(rs.getInt("copy_id"));
            }

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error searching resources");
        }

        return null;

    }

    private static Object readResource(int id,String type) throws SQLException {

        final String sql = "SELECT * FROM resources INNER JOIN "+type+" ON resources.resource_id="+type+".resource_id WHERE resources.resource_id = ?";

        ArrayList binds = new ArrayList();
        binds.add(id);

        ResultSet rs = runQuery(sql,binds);

        rs.next();

        ArrayList<Integer> copies = getCopies(id);
        String title = rs.getString("title");
        int year = rs.getInt("release_year");
        String imageID = rs.getString("image_ID");

        switch (type) {
            case ("book"):
                return new Book(id,title,year,imageID,copies,
                        rs.getString("author"), rs.getString("publisher"),
                        rs.getString("isbn"), rs.getString("language"));
            case ("laptop"):
                return new Laptop(id,title,year,imageID,copies,
                        rs.getString("manufacturer"), rs.getString("model"),
                        rs.getString("os"));
            default:
                return new DVD(id,title,year,imageID,copies,
                        rs.getString("director"),rs.getInt("runtime"),
                        rs.getString("subtitleLanguages").split(","),
                        rs.getString("language"));

        }

    }

    public static String getCopyState(int id) {

        try {

            final String sql = "SELECT copy_ID FROM loan WHERE copy_id = ? AND active = 1";

            ArrayList binds = new ArrayList();
            binds.add(id);

            ResultSet rs = runQuery(sql,binds);

            //Currently no loan = Available, 1 = borrowed, 0 = requested
            if (!rs.next()) {
                return "Available";
            } else if (rs.getInt("active") == 1) {
                return "Borrowed";
            } else {
                return "Requested";
            }

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error searching resources");
        }

        return "Copy not found";

    }

    public static int getNextAvailableID(String table) {

        try {
            final String sql = "SELECT auto_increment FROM information_schema.tables WHERE TABLE_NAME = '"+table+"'";

            ResultSet rs = runQuery(sql,new ArrayList<>());

            rs.next();

            return  rs.getInt("auto_increment");
        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error finding next ID");
        }

        return 0;

    }

    //Try to do with associative arrays?
    //
    public static ArrayList searchResource(Object searchTerm) {

        try {
            final String sql = "SELECT * FROM resources WHERE resource_ID = ? OR title LIKE ?";

            ArrayList binds = new ArrayList();
            binds.add(searchTerm);
            binds.add("%"+searchTerm.toString()+"%");

            ResultSet rs = runQuery(sql, binds);

            ArrayList resources = new ArrayList();

            //Get ids off all resources and put them into a list of their type
            while (rs.next()) {
                resources.add(readResource(rs.getInt("resource_id"),rs.getString("resource_type")));
            }

            return resources;
        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error searching resources");
        }

        return null;

    }

    //Writing

    private static int runUpdate(String sql,ArrayList<Object> binds) {

        try {
            String url = "jdbc:mysql://localhost:8080/cs230library";

            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement prepStmt = con.prepareStatement(sql);
            prepStmt = bindPreparedStatement(prepStmt,binds);

            return prepStmt.executeUpdate();

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error executing update");
        }

        return 0;

    }

    /**
     * Writes an object to the database
     * @param object the object to be written to the database
     * @return the number of affected rows
     */
    public static int writeObject(Object object) {

        if (object instanceof Resources) {
            return writeResource(object);
        }

        return 0;

    }

    /**
     * Writes a resource to the database
     * @param object the resource to be written to the database
     * @return the number of affected rows
     */
    private static int writeResource(Object object) {

        //Complete rework of method needed
        Resources resource = (Resources) object;
        String type = object.getClass().getSimpleName().toLowerCase();

        int rowsEdited = 0;

        //Resource Table

        final String resourceSQL = "INSERT INTO resources (resource_id,image_id,resource_type,title,release_year) " +
                "VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE image_id = ?,resource_type = ?, title = ?," +
                " release_year = ?";

        ArrayList binds = new ArrayList();
        binds.addAll(Arrays.asList(resource.getID(),resource.getimageID(),type,resource.getTitle(),resource.getYear(),
                resource.getimageID(),type,resource.getTitle(),resource.getYear()));

        rowsEdited += runUpdate(resourceSQL,binds);

        //Copies

        final String copySQL = "INSERT INTO copy (copy_id,resource_id,status) VALUES (?,?,?) ON DUPLICATE KEY UPDATE" +
                " resource_id = ?,status = ?";

        binds.clear();

        for (int id : resource.getCopies()) {
            binds.add(id);
            binds.add(resource.getID());
            String state = Conn.getCopyState(id);
            binds.add(state);
            binds.add(resource.getID());
            binds.add(state);
            rowsEdited += runUpdate(copySQL,binds);
            binds.clear();
        }

        //Specific Table

        String objectSQL = "";

        //Improve loads
        if (object instanceof Book) {
            objectSQL = "INSERT INTO book (resource_id,author,publisher,isbn,language) VALUES (?,?,?,?,?)"+
                    " ON DUPLICATE KEY UPDATE author = ?,publisher = ?,isbn = ?,language = ?";
            Book book = (Book) object;
            binds.addAll(Arrays.asList(book.getID(),book.getAuthor(),book.getPublisher(),
                    book.getISBN(),book.getLanguage(),book.getAuthor(),book.getPublisher(),
                    book.getISBN(),book.getLanguage()));
        } else if (object instanceof Laptop) {
            objectSQL = "INSERT INTO book (resource_id,manufacturer,model,os) VALUES (?,?,?,?)"+
                    " ON DUPLICATE KEY UPDATE manufacturer = ?,model = ?,os = ?";
            Laptop laptop = (Laptop) object;
            binds.addAll(Arrays.asList(laptop.getID(),laptop.getManufacturer(),laptop.getModel(),
                    laptop.getOperatingSystem(),laptop.getManufacturer(),laptop.getModel(),
                    laptop.getOperatingSystem()));
        } else if (object instanceof DVD) {
            objectSQL = "INSERT INTO dvd (resource_id,director,runtime,language,subtitleLanguages) " +
                    "VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE director = ?,runtime = ?," +
                    "language = ?,subtitleLanguages = ?";
            DVD dvd = (DVD) object;
            binds.addAll(Arrays.asList(dvd.getID(),dvd.getDirector(),dvd.getRuntime(),dvd.getLanguage(),
                    dvd.getSubtitleLanguages(),dvd.getDirector(),dvd.getRuntime(),dvd.getLanguage(),
                    dvd.getSubtitleLanguages()));
        }

        rowsEdited += runUpdate(objectSQL,binds);

        return rowsEdited;
    }

}
