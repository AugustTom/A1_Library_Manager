import java.util.Date;

public class Librarian extends User {

    private String employDate;
    private int staffNum;

    public Librarian(String userName, String firstName, String lastName, String phoneNum, double balance,
                     String avatarID, Address address, String employDate, int staffNum) {

        super(userName, firstName, lastName, phoneNum, balance, avatarID, address);

        this.employDate = employDate;
        this.staffNum = staffNum;

    }

    public String getEmployDate() {
        return employDate;
    }

    public void setEmployDate(String employDate) {
        this.employDate = employDate;
    }

    public int getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }
}
