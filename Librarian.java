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

    public Librarian(String userName, String firstName, String lastName, String phoneNum, double balance,
                     String avatarID, Address address, String employDate, int staffNum) {

        super(userName, firstName, lastName, phoneNum, balance, avatarID, address);

        this.employDate = employDate;
        this.staffNum = staffNum;

    }
    
    /**
     * get method for employment date
     * @return employDate
     */

    public String getEmployDate() {
        return employDate;
    }
    
    /**
     * set method for employment date
     * @param employDate
     */

    public void setEmployDate(String employDate) {
        this.employDate = employDate;
    }
    
    /**
     * get method for staff number
     * @return staffNum
     */

    public int getStaffNum() {
        return staffNum;
    }
    
    /**
     * set method for staff number
     * @param staffNum
     */

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }
}
