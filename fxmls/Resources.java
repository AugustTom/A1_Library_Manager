package GUI;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Resources {

    private SimpleIntegerProperty ID;
    private SimpleStringProperty title;
    private SimpleIntegerProperty year;
    private SimpleStringProperty thumbnailImageID;
    private SimpleIntegerProperty loanDuration;
    private SimpleIntegerProperty numberOfCopies;
    private SimpleIntegerProperty availableCopies;
    private SimpleIntegerProperty borrowedCopies;

    public Resources(int ID, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
                     int availableCopies, int borrowedCopies) {
        this.ID = new SimpleIntegerProperty(ID);
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.thumbnailImageID = new SimpleStringProperty(thumbnailImageID);
        this.loanDuration = new SimpleIntegerProperty(loanDuration);
        this.numberOfCopies = new SimpleIntegerProperty(numberOfCopies);
        this.availableCopies = new SimpleIntegerProperty(availableCopies);
        this.borrowedCopies = new SimpleIntegerProperty(borrowedCopies);
}

    public boolean checkAvailability(){
        return true;
    }

    public int getID() {
        return ID.get();
    }

    public SimpleIntegerProperty IDProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public String getThumbnailImageID() {
        return thumbnailImageID.get();
    }

    public SimpleStringProperty thumbnailImageIDProperty() {
        return thumbnailImageID;
    }

    public void setThumbnailImageID(String thumbnailImageID) {
        this.thumbnailImageID.set(thumbnailImageID);
    }

    public int getLoanDuration() {
        return loanDuration.get();
    }

    public SimpleIntegerProperty loanDurationProperty() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration.set(loanDuration);
    }

    public int getNumberOfCopies() {
        return numberOfCopies.get();
    }

    public SimpleIntegerProperty numberOfCopiesProperty() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies.set(numberOfCopies);
    }

    public int getAvailableCopies() {
        return availableCopies.get();
    }

    public SimpleIntegerProperty availableCopiesProperty() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies.set(availableCopies);
    }

    public int getBorrowedCopies() {
        return borrowedCopies.get();
    }

    public SimpleIntegerProperty borrowedCopiesProperty() {
        return borrowedCopies;
    }

    public void setBorrowedCopies(int borrowedCopies) {
        this.borrowedCopies.set(borrowedCopies);
    }
}
