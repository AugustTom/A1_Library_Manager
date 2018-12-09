package tawelib;

import java.util.ArrayList;

public class Resources {

    //public enum State {AVAILABLE, BORROWED, REQUESTED};
    private int id;
    private String title;
    private int year;
    private String imageID;
    //private State state;
    private ArrayList<Integer> copies;

    public Resources(int id, String title, int year, String imageID, ArrayList<Integer> copies) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imageID = imageID;
        this.copies = copies;
    }

    public void setCopies(ArrayList<Integer> copies) {
        this.copies = copies;
    }

    public ArrayList<Integer> getCopies() {
        return this.copies;
    }

    //Checks if any of the copies are available and if any are sets
    public boolean checkAvailability(){

        for(int copyid : this.copies) {
            if (Conn.getCopyState(copyid) == "Available") {
                return true;
            }
        }

        return false;

    }

    public void setState(ArrayList<Integer> copies){
        this.copies = copies;
    }

    public int getResourceID() {
        
        Conn.getNextAvailableID(String Resource);
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getimageID() {
        return imageID;
    }

    public void setimageID(String imageID) {
        this.imageID = imageID;
    }

}
