package tawelib;

import java.util.ArrayList;

/** 
 * This class is a subclass of the Resources superclass 
 * <br> 
 * It stores stores information about a book 
 * 
 * 
 * @author Ronalyn Lilyanne 
 * @version 1.0 
 * @since 05/12/2018 
 */ 

public class Book extends Resources {
    protected String author;
    protected String publisher;
    protected String ISBN;
    protected String language;
    
    /**
     * This is a book constructor and it is needed to initialize a book object
     * @param id extends from Resources class- id of a book
     * @param title extends from Resources class - title of a book
     * @param year extends from Resources class - book year of publication 
     * @param imageID extends from Resources class - ID of a book's image 
     * @param copies extends from Resources class - amount of copies of a book 
     * @param author - the author of a book 
     * @param publisher - the publisher of a book 
     * @param ISBN - the International Standard Book Number of a book 
     * @param language - the language in which a book is written 
     */

    public Book (int id, String title, int year, String imageID, ArrayList<Integer> copies,
                 String author, String publisher, String ISBN, String language){
        super(id, title, year, imageID, copies);
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.language = language;
    }
    
    /** 
    * get method for author 
    * @return author 
    */ 

    public String getAuthor() {
        return author;
    }
    
    /** 
    * set method for author 
    * @param author - sets the author
    */ 

    public void setAuthor(String author) {
        this.author = author;
    }
    
    /** 
    * get method for publisher 
    * @return publisher 
    */

    public String getPublisher() {
        return publisher;
    }
    
    /** 
    * set method for publisher 
    * @param publisher - sets the publisher
    */ 

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    /** 
    * get method for ISBN 
    * @return ISBN 
    */ 
  
    public String getISBN() {
        return ISBN;
    }
    
    /** 
    * set method for ISBN 
    * @param ISBN - sets the ISBN
    */ 

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    /** 
    * get method for language 
    * @return language 
    */ 

    public String getLanguage() {
        return this.language;
    }
    
    /** 
    * set method for language 
    * @param languages - sets the language
    */

    public void setLanguage(String languages) {
        this.language = languages;
    }
}
