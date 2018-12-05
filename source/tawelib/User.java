/**
 * This class is a superclass of the Librarian subclass
 * <br>
 * It stores information about a User
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 05/12/2018
 */

public class User {

	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String phoneNum;
	protected Double balance;
	protected String avatarID;

	public User(String userName, String firstName, String lastName, String phoneNum, Double balance, String avatarID) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.balance = balance;
		this.avatarID = avatarID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setPhone(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhone() {
		return phoneNum;
	}

	public void setAvatarID(String avatarID) {
		this.avatarID = avatarID;
	}

	public String getAvatarID() {
		return avatarID;
	}
}
