package tawelib;

/** 
 * The Address class maintains the data about one address.
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
	* This Address constructor is needed to initialise an address object.
	* @param id - id of an address
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
	 * @param id - Sets the id address
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
	 * @param houseName - sets the house name
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
	 * @param streetName - sets the street name
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
	 * @param city - sets the city
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
	 * @param postCode - sets the post code
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
