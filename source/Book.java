package GUI;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 */
public class Book extends Resources {
    protected SimpleStringProperty author;
    protected SimpleStringProperty publisher;
    protected SimpleStringProperty genre;
    protected SimpleStringProperty ISBN;
    protected SimpleStringProperty languages;

    public Book (int id, String title, int year, String thumbnailImageID, int loanDuration, int numberOfCopies,
                 int availableCopies, int borrowedCopies, String author, String publisher, String genre,
                 String ISBN, String languages){
        super(id, title, year, thumbnailImageID, loanDuration, numberOfCopies, availableCopies, borrowedCopies);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.genre = new SimpleStringProperty(genre);
        this.ISBN = new SimpleStringProperty(ISBN);
        this.languages = new SimpleStringProperty(languages);
    }


    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getPublisher() {
        return publisher.get();
    }

    public SimpleStringProperty publisherProperty() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
    }

    public String getGenre() {
        return genre.get();
    }

    public SimpleStringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getISBN() {
        return ISBN.get();
    }

    public SimpleStringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public String getLanguages() {
        return languages.get();
    }

    public SimpleStringProperty languagesProperty() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages.set(languages);
    }
}
