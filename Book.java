/**
 *
 */
public class Book extends Resources {
    protected String author;
    protected String publisher;
    protected String ISBN;
    protected String languages;

    public Book (int id, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
                 String author, String publisher, String ISBN, String languages){
        super(id, title, year, thumbnailImageID, loanDuration, numberOfCopies);
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.languages = languages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
