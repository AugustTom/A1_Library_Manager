package tawelib;

public class Address {

    private int id;
    private String houseName;
    private String streetName;
    private String city;
    private String postCode;

    public Address(int id,String houseName,String streetName,String city,String postCode) {

        this.id = id;
        this.houseName = houseName;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

}
