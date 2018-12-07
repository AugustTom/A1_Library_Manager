package tawelib;

public class User {

	protected String userName;
	protected String firstName;
	protected String lastName;
	protected String phoneNum;
	protected Double balance;
	protected String avatarID;
	protected Address address;

	public User(String userName, String firstName, String lastName, String phoneNum, Double balance,
				Address address, String avatarID) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.balance = balance;
		this.avatarID = avatarID;
		this.address = address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return this.address;
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
