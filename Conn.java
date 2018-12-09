package tawelib;

import javax.management.AttributeList;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the connection class that connects the source code to the database
 *
 *
 * @author James Hinns
 * @version 1.0
 * @since 09/12/2018
 */

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

    /**
     * This method retrieves address data from the database via an SQL query and outputs the result set
     * @return the full address
     */

    private static Address getAddress(int id) throws SQLException {

        final String sql = "SELECT * FROM address WHERE address_ID = ?";

        ArrayList binds = new ArrayList();
        binds.add(id);

        ResultSet rs = runQuery(sql,binds);

        rs.next();

        return new Address(rs.getInt("address_ID"),rs.getString("house_name"),
                rs.getString("street_name"),rs.getString("city"),
                rs.getString("post_code"));

    }
    
    /**
     * This method retrieves librarian data from the database via an SQL query and outputs the result set
     * @return the librarian attributes
     */

    private static Librarian getLibrarian(String username,Address address) throws SQLException {

        final String sql = "SELECT * FROM users INNER JOIN librarian ON users.username=librarian.username WHERE " +
                "users.username = librarian.username AND users.username = ?";

        ArrayList binds = new ArrayList();
        binds.add(username);

        ResultSet rs = runQuery(sql,binds);

        rs.next();

        return new Librarian(username,rs.getString("fname"),rs.getString("sname"),
                rs.getString("phone_number"),rs.getDouble("balance"),
                rs.getString("avatar_id"),address,
                rs.getString("employment_date"),rs.getInt("staff_id"));

    }
    
    /**
     * This method checks if the entered username is a librarian via an SQL query and outputs a boolean
     * @return false if the username is not a librarian
     */

    public static boolean isLibrarian(String username) {

        try {
            final String sql = "SELECT username FROM librarian WHERE username = ?";

            ArrayList binds = new ArrayList();
            binds.add(username);

            ResultSet rs = runQuery(sql, binds);

            return rs.next();
        } catch (SQLException err) {
            System.out.println(err.getMessage() + "Error checking if librarian");
        }

        return false;

    }
    
   
    public static ArrayList searchUsers(String searchTerm) {

        ArrayList users = new ArrayList();

        try {
            final String sql = "SELECT * FROM users WHERE username = ? OR CONCAT(fName,' ',sName) LIKE ?";

            ArrayList binds = new ArrayList();
            binds.add(searchTerm);
            binds.add("%"+searchTerm.toString()+"%");


            ResultSet rs = runQuery(sql,binds);

            Address address;

            while(rs.next()) {

                address = getAddress(rs.getInt("address_id"));
                String username = rs.getString("username");

                if (!isLibrarian(username)) {
                    users.add(new User(username,rs.getString("fname"),rs.getString("sname"),
                            rs.getString("phone_number"),rs.getDouble("balance"),
                            rs.getString("avatar_id"),address));
                } else if (isLibrarian(username)){
                    users.add(getLibrarian(username,address));
                }

            }

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error searching users");
        }

        return users;

    }
    
    

    public static ResultSet getActiveLoan(int id,String username) {

        final String sql = "SELECT * FROM loan WHERE copy_id = ? AND username = ? AND active = 'onloan'";

        ArrayList binds = new ArrayList();
        binds.add(id);
        binds.add(username);

        return runQuery(sql,binds);

    }

    public static  ResultSet getLoanRequest(int id,String username) {

        final String sql = "SELECT * FROM loan WHERE copy_id = ? AND username = ? AND active = 'requested'";

        ArrayList binds = new ArrayList();
        binds.add(id);
        binds.add(username);

        return runQuery(sql,binds);

    }

    //Loan and Borrow stuff

    private static ResultSet runQuery(String sql,ArrayList<Object> binds) {

        try {
            String url = "jdbc:mysql://localhost:3306/cs230library";

            Connection con = DriverManager.getConnection(url, "root", "2Sg3zMab$66");

            PreparedStatement prepStmt = con.prepareStatement(sql);
            prepStmt = bindPreparedStatement(prepStmt,binds);

            return prepStmt.executeQuery();

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error executing query");
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

        final String sql = "SELECT * FROM resources INNER JOIN "+type+" ON resources.resource_id="+type+".resource_id " +
                "WHERE resources.resource_id = ?";

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

            final String sql = "SELECT copy_ID FROM loan WHERE copy_id = ?";

            ArrayList binds = new ArrayList();
            binds.add(id);

            ResultSet rs = runQuery(sql,binds);

            //Currently no loan = Available, 1 = borrowed, 0 = requested
            if (!rs.next()) {
                return "Available";
            } else if (rs.getString("active") == "onloan") {
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

    public static int writeLoan(int id,String username,String datetime,String active) {

        final String loanSQL = "INSERT INTO loan (copy_id,username,loan_datetime,active)" +
                "VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE loan_datetime = ?,active = ?";

        ArrayList binds = new ArrayList();
        binds.addAll(Arrays.asList(id,username,datetime,active,datetime,active));

        return runUpdate(loanSQL,binds);

    }

    private static int runUpdate(String sql,ArrayList<Object> binds) {

        try {
            String url = "jdbc:mysql://localhost:3306/cs230library";

            Connection con = DriverManager.getConnection(url, "root", "2Sg3zMab$66");

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
        } else if (object instanceof User) {
            return writeUser(object);
        } else if (object instanceof Address) {
            return writeAddress((Address) object);
        }

        return 0;

    }

    private static int writeUser(Object object) {

        //General

        final String userSQL = "INSERT INTO users (username,fname,sname,phone_number,address_id,balance,avatar_id) " +
                "VALUES (?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE fname = ?,sname = ?,phone_number = ?,address_id = ?," +
                "balance = ?,avatar_id = ?";

        User user = (User) object;
        int rows = 0;
        rows += writeAddress(user.getAddress());
        ArrayList binds = new ArrayList();
        binds.addAll(Arrays.asList(user.getUserName(), user.getFirstName(), user.getLastName(), user.getPhone(),
                user.getAddress().getId(), user.getBalance(),user.getAvatarID(), user.getFirstName(), user.getLastName(), user.getPhone(),
                user.getAddress().getId(), user.getBalance(),user.getAvatarID()));

        rows += runUpdate(userSQL,binds);
        binds.clear();

        if (object instanceof Librarian) {
            final String libSQL = "INSERT INTO librarian (staff_id,username,employment_date) " +
                    "VALUES (?,?,?) ON DUPLICATE KEY UPDATE username = ?, employment_date = ?";

            Librarian lib = (Librarian) object;
            binds.addAll(Arrays.asList(lib.getStaffNum(),lib.getUserName(),lib.getEmployDate(),
                    lib.getUserName(),lib.getEmployDate()));

            rows += runUpdate(libSQL,binds);

        }

        rows += writeAddress(user.getAddress());

        return rows;

    }

    private static int writeAddress(Address address) {

        final String sql = "INSERT INTO address (address_id,post_code,house_name,street_name,city) " +
                "VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE post_code = ?,house_name = ?,street_name = ?," +
                "city = ?";

        ArrayList binds = new ArrayList();
        binds.addAll(Arrays.asList(address.getId(),address.getPostCode(),address.getHouseName(),address.getStreetName(),
                address.getCity(),address.getPostCode(),address.getHouseName(),address.getStreetName(),
                address.getCity()));

        return runUpdate(sql,binds);
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
