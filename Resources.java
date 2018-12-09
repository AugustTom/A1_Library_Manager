package tawelib;

import java.util.ArrayList;

/**
 * This class is the Resources Super class, its Sub Classes are Book, DVD and Laptop.
 * <br>
 * It stores information on a resource within the database.
 *
 *
 *@author Ronalyn Lilyanne
 *@version 1.0
 *@since 04/12/2018
 */

public class Resources {

    //public enum State {AVAILABLE, BORROWED, REQUESTED};
    private int id;
    private String title;
    private int year;
    private String imageID;
    //private State state;
    private ArrayList<Integer> copies;
    
    /**
     * This is the resources constructor and is needed to initialise an object of resource
     * @param id - the resource ID
     * @param title - the title of the resource
     * @param year - the year the resource was made
     * @param imageID - the image ID of the resource
     * @param copies - how many copies of that resource are available
     */

    public Resources(int id, String title, int year, String imageID, ArrayList<Integer> copies) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imageID = imageID;
        this.copies = copies;
    }
    
    /**
     * set method for copies
     * @param copies - the amount of copies of that resource
     */

    public void setCopies(ArrayList<Integer> copies) {
        this.copies = copies;
    }
    
    /**
     * an array list of copies available
     * @return the list of copies
     */

    public ArrayList<Integer> getCopies() {
        return this.copies;
    }
    
    /**
     * Checks if any of the copies are available and if any are sets
     * @return the availability of the copy
     */

    //Checks if any of the copies are available and if any are sets
    public boolean checkAvailability(){

        for(int copyid : this.copies) {
            if (Conn.getCopyState(copyid) == "Available") {
                return true;
            }
        }

        return false;

    }
    
    /**
     * set method for the copy state
     * @param copies - copes of the resource
     */

    public void setState(ArrayList<Integer> copies){
        this.copies = copies;
    }
    
    /**
     * get method for resource ID
     * @return resource ID
     */

    public int getID() {
        return id;
    }
    
    /**
     * set method for the resource ID
     * @param id - resource ID
     */
     
    public void setID(int id) {
        this.id = id;
    }
    
    /**
     * get method for the resource title
     * @return the resource title
     */

    public String getTitle() {
        return title;
    }
    
    /**
     * set method for the resource title
     * @param title - title of the resource
     */

    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * get method for the resource year
     * @return the resource year
     */

    public int getYear() {
        return year;
    }
    
    /**
     * set method for the resource year
     * @param year - the year the resource was made
     */

    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * get method for the imageID
     * @return the image ID
     */

    public String getimageID() {
        return imageID;
    }
    
    /**
     * set method for the image iD
     * @param imageID - the image ID
     */

    public void setimageID(String imageID) {
        this.imageID = imageID;
    }

}
