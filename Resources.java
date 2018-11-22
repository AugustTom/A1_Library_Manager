public class Resources {

    public enum State {AVAILABLE, BORROWED, REQUESTED};
    private int ID;
    private String title;
    private int year;
    private String thumbnailImageID;
    private int loanDuration;
    private int numberOfCopies;
    private State state;

    public Resources(int ID, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
                     State state) {
        this.ID = ID;
        this.title = title;
        this.year = year;
        this.thumbnailImageID = thumbnailImageID;
        this.loanDuration = loanDuration;
        this.numberOfCopies = numberOfCopies;
        this.state = state;
    }

    public boolean checkAvailability(){
        return true;
    }
    public void setState(State state){
        this.state = state;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getThumbnailImageID() {
        return thumbnailImageID;
    }

    public void setThumbnailImageID(String thumbnailImageID) {
        this.thumbnailImageID = thumbnailImageID;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
