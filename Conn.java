package tawelib;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/* This class is the connection manager for the database
 * <br>
 * It performs quries for relevant data and alters the database when new data is added.
 *
 *
 * @author James Hinnis
 * @version 3.0
 * @since 03/12/2018
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
                } else if (binds.get(i) instanceof Long) {
                    prepStmt.setLong(i+1,(Long) binds.get(i));
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

    public static double getFines(String username) {


        final String sql = "SELECT * FROM loan INNER JOIN copy ON copy.copy_ID = loan.copy_ID " +
                "INNER JOIN resources ON resources.resource_id = copy.resource_id " +
                "WHERE loan.username = ? AND active = 'onloan'";

        final String otherSQL = "SELECT *" +
                "FROM `loan`" +
                "WHERE copy_ID = ? AND loan_datetime > ? AND active = 'requested' ORDER BY loan_datetime DESC";

        final String moreSQL = "SELECT resource_type FROM loan INNER JOIN copy ON copy.copy_ID = loan.copy_ID " +
                "INNER JOIN resources ON resources.resource_id = copy.resource_id " +
                "WHERE loan.copy_id = ?";

        ArrayList binds = new ArrayList();
        binds.add(username);

        ResultSet rs = runQuery(sql,binds);

        try {

            while (rs.next()) {

                //If the request is older than a week
                if (System.currentTimeMillis() - (604800000) + (rs.getLong("loan_datetime")) > 0) {

                    binds.clear();
                    binds.add(rs.getInt("copy_id"));
                    binds.add(rs.getLong("loan_datetime"));

                    ResultSet rs2 = runQuery(otherSQL, binds);

                    while (rs2.next()) {
                        //If request is older than 2 days
                        if ((System.currentTimeMillis() - 86400000 + (rs2.getLong("loan_datetime"))) > 0) {
                            binds.clear();
                            binds.add(rs.getInt("copy_id"));

                            ResultSet rs3 = runQuery(moreSQL, binds);

                            rs3.next();

                            String type = rs3.getString("resource_type");

                            if (type.equals("laptop")) {
                                return Math.max(25,2 * ((System.currentTimeMillis() - (rs2.getLong("loan_datetime"))) / 86400000));
                            } else {
                                return Math.max(100,10 * ((System.currentTimeMillis() - (rs2.getLong("loan_datetime"))) / 86400000));
                            }

                        }

                    }

                }

            }

        } catch (SQLException err) {
            System.out.println("Error getting fines");
        }

        return 0;

    }



    //Reading

    /**
     * Creates an address object from the database given address id
     * @param id the address id of the address to be fetched
     * @return The created address object
     * @throws SQLException
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
     * Creates a Librarian object from the database given a username and created address object
     * @param username The username of the librarian
     * @param address A created address object
     * @return Created Librarian Object
     * @throws SQLException
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
     * Checks whether a given username belongs to a librarian or not
     * @param username The username to check
     * @return True if a librarian has the given username, false if not
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

    /**
     * Creates an arraylist filled with users and librarians where they relate to the search term
     * @param searchTerm The term to be searched
     * @return Arraylist of users and librarians
     */
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

    /**
     * Get all active loans for a given user (represented by username)
     * @param username The username of the user whose loans you are searching for
     * @return An arraylist of all objects currently loaned to the user
     */
    public static ArrayList getActiveLoans(String username) {

        try {

            final String sql = "SELECT * FROM loan INNER JOIN copy ON copy.copy_ID = loan.copy_ID " +
                    "INNER JOIN resources ON resources.resource_id = copy.resource_id " +
                    "WHERE loan.username = ? AND active = 'onloan'";

            ArrayList binds = new ArrayList();
            binds.add(username);

            ResultSet rs = runQuery(sql,binds);

            ArrayList requests = new ArrayList();

            while (rs.next()) {
                requests.add(readResource(rs.getInt("resource_id"),rs.getString("resource_type")));
            }

            return requests;

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error getting loan requests");
        }

        return null;

    }

    /**
     * Get all loan requests for a given user (represented by username)
     * @param username The username of the user whose loans you are searching for
     * @return An arraylist of all objects currently requested by the user
     */
    public static ArrayList getLoanRequests(String username) {

        try {

            final String sql = "SELECT * FROM loan INNER JOIN copy ON copy.copy_ID = loan.copy_ID " +
                    "INNER JOIN resources ON resources.resource_id = copy.resource_id " +
                    "WHERE loan.username = ? AND active = 'requested'";

            ArrayList binds = new ArrayList();
            binds.add(username);

            ResultSet rs = runQuery(sql,binds);

            ArrayList requests = new ArrayList();

            while (rs.next()) {
                requests.add(readResource(rs.getInt("resource_id"),
                        rs.getString("resource_type")));
            }

            return requests;

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error getting loan requests");
        }

        return null;

    }

    /**
     * Runs a query on the database given a sql string and an array of objects to bind to it
     * @param sql A string storing the sql query
     * @param binds An arraylist of objects to bind to the sql statement
     * @return The result set of the query
     */
    private static ResultSet runQuery(String sql,ArrayList<Object> binds) {

        try {

            String url = "jdbc:mysql://localhost:3306/cs230library";

            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement prepStmt = con.prepareStatement(sql);
            prepStmt = bindPreparedStatement(prepStmt,binds);

            return prepStmt.executeQuery();

        } catch ( SQLException err ) {
            System.out.println( err.getMessage() + "Error executing query");
        }

        return null;

    }

    /**
     * Returns an array of integers containing copy ids given a resource id
     * @param id The resource id
     * @return An arraylist of copy id
     */
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

    /**
     * Read in a resource given its id and type
     * @param id The resource id
     * @param type The type of the resource, e.g. Book,Laptop or DVD
     * @return An object of type book,laptop or dvd
     * @throws SQLException
     */
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

    /**
     * Get the state of copy e.g. Available,Requested Or Borrowed
     * @param id The id of the copy to check
     * @return The string of the copies state
     */
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

    /**
     * Get the next available id in the database given a table
     * @param table The database table name to check (NOT A PREPARED STATEMENT)
     * @return The number of affected rows
     */
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

    /**
     * Creates an arraylist filled with resources where they relate to the search term
     * @param searchTerm The term to search against
     * @return An arraylist of resources
     */
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

    /**
     * Writes a loan to the loan table, given an id, username and state
     * @param id The copy id of the loaned resource
     * @param username The username of the user in the transaction
     * @param active The state of the loan e.g. onloan,returned,requested
     * @return The number of affected rows
     */
    public static int writeLoan(int id,String username,String active) {

        long timeMillis = System.currentTimeMillis();

        int rowsAffected = 0;

        //Loan

        final String loanSQL = "INSERT INTO loan (copy_id,username,loan_datetime,active)" +
                "VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE loan_datetime = ?,active = ?";

        ArrayList binds = new ArrayList();
        binds.addAll(Arrays.asList(id,username,timeMillis,active,timeMillis,active));

        rowsAffected += runUpdate(loanSQL,binds);

        //Copy

        final String copySQL = "UPDATE copy SET status = 'Requested' WHERE copy_ID = ?";

        binds.clear();

        binds.add(id);

        rowsAffected += runUpdate(copySQL,binds);

        return rowsAffected;

    }

    /**
     * Inserts of updates the database given a sql, and an arraylist of objects to bind to it
     * @param sql A string storing the sql query
     * @param binds An arraylist of objects to bind to the sql query
     * @return The number of affected rows
     */
    private static int runUpdate(String sql,ArrayList<Object> binds) {

        try {
            String url = "jdbc:mysql://localhost:3306/cs230library";

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
        } else if (object instanceof User) {
            return writeUser(object);
        } else if (object instanceof Address) {
            return writeAddress((Address) object);
        }

        return 0;

    }

    /**
     * Writes a users data to the database
     * @param object the user object
     * @return the number of affected rows
     */
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

        return rows;

    }

    /**
     * Writes an addresses data to the database
     * @param address The address to be written to the database
     * @return the number of affected rows
     */
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
