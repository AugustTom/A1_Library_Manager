package tawelib;

/* This class is a subclass of the User superclass
 * <br>
 * It stores information about a Librarian
 *
 *
 * @author Sam Hurford
 * @author Kristofas Haroun
 * @version 1.0
 * @since 05/12/2018
 */

public class Librarian extends User {

    private String employDate;
    private int staffNum;
    
    /**
     * This is a Librarian constructor and it is needed to initialise a Librarian object
     * @param userName extends from the superclass User - username of a librarian
     * @param firstName extends from the superclass User - first name of a librarian
     * @param lastName extends from the superclass User - last name of a librarian
     * @param phoneNum extends from the superclass User - phone number of a librarian
     * @param balance extends from the superclass User - balance of a librarian
     * @param avatarID extends from the superclass User - avatar ID of a librarian
     * @param address extends from the superclass User - address of a librarian
     * @param employDate - employment date of a librarian
     * @param staffNum - staff number of a librarian
     */

    public Librarian(String userName, String firstName, String lastName, String phoneNum, double balance,
                     String avatarID, Address address, String employDate, int staffNum) {

        super(userName, firstName, lastName, phoneNum, balance, avatarID, address);

        this.employDate = employDate;
        this.staffNum = staffNum;

    }
    
    /**
     * get method for employment date
     * @return employDate - returns the employdate
     */

    public String getEmployDate() {
        return employDate;
    }
    
    /**
     * set method for employment date
     * @param employDate - sets the employ date
     */

    public void setEmployDate(String employDate) {
        this.employDate = employDate;
    }
    
    /**
     * get method for staff number
     * @return staffNum - returns the staff number
     */

    public int getStaffNum() {
        return staffNum;
    }
    
    /**
     * set method for staff number
     * @param staffNum - sets the staff number
     */

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }
}
