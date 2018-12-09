package tawelib;

/** 
 * This class stores information about the address of a user or librarian
 *
 *
 * @author Kristofas Haroun
 * @author Sam Hurford
 * @version 1.0
 * @since 09/12/2018
 */ 

public class Address {
	private int id;
        private String houseName;
	private String streetName;
	private String city;
	private String postCode;
	
	/**
	* This is an address contructor and it is needed to initialise an address object
	* @param id - ID of an address
	* @param houseName - the house name of an address
	* @param streetName - the street name of an address
	* @param city - city of an address
	* @param postCode - the post code of an address
	*/
	
	public Address(int id,String houseName,String streetName,String city,String postCode) {

	    this.id = id;
		this.houseName = houseName;
		this.streetName = streetName;
		this.city = city;
		this.postCode = postCode;

	}
	
	/**
	 * Set method for address ID
	 * @param id
	 */
	
	public void setId(int id) {
        this.id = id;
	}
	
	/**
	 * Get method for address ID
	 * @return id
	 */

        public int getId() {
        return id;
        }
	
	/**
	 * Set method for house name
	 * @param houseName
	 */

        public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	/**
	 * Get method for house name
	 * @return houseName
	 */
	
	public String getHouseName() {
		return houseName;
	}
	
	/**
	 * Set method for street name
	 * @param streetName
	 */

        public void setStreetName(String streetName) {
        this.streetName = streetName;
        }
	
	/**
	 * Get method for street name
	 * @return streetName
	 */

        public String getStreetName() {
        return streetName;
        }
	
	/**
	 * Set method for city
	 * @param city
	 */

        public void setCity(String city) {
        this.city = city;
        }
	
	/**
	 * Get method for city
	 * @return city
	 */

        public String getCity() {
        return city;
        }
	
	/**
	 * Set method for postcode
	 * @param postCode
	 */

        public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	/**
	 * Get method for postcode
	 * @return postCode
	 */
	
	public String getPostCode() {
		return postCode;
	}

}
