import java.util.ArrayList;

public class Book extends Resources {
    protected String author;
    protected String publisher;
    protected String ISBN;
    protected String language;

    public Book (int id, String title, int year, String imageID, ArrayList<Integer> copies,
                 String author, String publisher, String ISBN, String language){
        super(id, title, year, imageID, copies);
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.language = language;
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

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String languages) {
        this.language = languages;
    }
}