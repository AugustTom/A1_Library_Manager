package tawelib;

/* It stores information about a User
 *
 * @author Sam Hurford
 * @author Kristofas Haroun
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
	protected Address address;
	
	/**
	* This is a User constructor that initialises an instance of a user
	* @param userName - the username of a user
	* @param firstName - the first name of a user
	* @param lastName - the last name of a user
	* @param phoneNum - the phone number of a user
	* @param balance - the balance of a user
	* @param avatarID - the ID of the avatar of a user
	* @param address - the address of a user
	*/
	
	public User(String userName, String firstName, String lastName, String phoneNum, Double balance, String avatarID, Address address) {
		
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.balance = balance;
		this.avatarID = avatarID;
		this.address = address;

	}
	
	/**
	* set method for address
	* @param address
	*/

	public void setAddress(Address address) {
        this.address = address;
    	}
	
	/**
	* get method for address
	* @return address
	*/

    	public Address getAddress() {
	    return this.address;
    	}
	
	/**
	* set method for username
	* @param userName
	*/
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	* get method for username
	* @return userName
	*/
	
	public String getUserName() {
		return userName;
	}
	
	/**
	* set method for first name
	* @param firstName
	*/
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	* get method for first name
	* @return firstName
	*/
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	* set method for last name
	* @param lastName
	*/
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	* get method for last name
	* @return lastName
	*/
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	* set method for phone number
	* @param phoneNum
	*/
	
	public void setPhone(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	* get method for phone number
	* @return phoneNum
	*/
	
	public String getPhone() {
		return phoneNum;
	}
	
	/**
	* get method for balance
	* @return balance
	*/

   	public Double getBalance() {
        return balance;
    	}
	
	/**
	* set method for balance
	* @param balance
	*/

    	public void setBalance(Double balance) {
        this.balance = balance;
    	}
	
	/**
	* set method for avatar ID
	* @param avatarID
	*/

    	public void setAvatarID(String avatarID) {
		this.avatarID = avatarID;
	}
	
	/**
	* get method for avatarID
	* @return avatarID
	*/
	
	public String getAvatarID() {
		return avatarID;
	}

}
