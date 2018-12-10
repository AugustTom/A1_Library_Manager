package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This AddNewBookController Class pairs with the "AddNewBook.fxml" file
 * Handles all widgets within the fxml file and returns the appropriate values.
 *
 * @author Auguste Tomaseviciute
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewBookController extends AddNewSuperclassController {

    //These text fields correspond to the editable textfields within the fxml file.
    @FXML
    private TextField newBookAuthor;

    @FXML
    private TextField newBookPublisher;

    @FXML
    private TextField newBookISBN;

    @FXML
    private TextField newBookLanguage;
    
    /**
     * This method adds a new book to the database, it reads the input text from the
     * fxml fields and translates them into usable data which constructs a book objecty,
     * that object is then written to the Conn class which writes it as a entry to the database.
     * <br>
     * It contains a constructor to initialise a book object.
     * @param event
     * @throws IOException
     */
    
    @FXML
    public void addNewBook(ActionEvent event) throws IOException {

        //Initially there is one copy
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

        //Fetches the next free resourceID so that every resource has a unique identifier in the database.
        int bookID = Conn.getNextAvailableID("resource");

        //Retrieves input data from fxml fields and stores them in usable variables.
        String bookTitle = titleField.getText();
        int bookYear = Integer.parseInt(yearField.getText());
        String imageID = pathToImage;
        int bookNumOfCopies = Integer.parseInt(numOfCopiesField.getText());
        String bookAuthor = newBookAuthor.getText();
        String bookPublisher = newBookPublisher.getText();
        String bookISBN = newBookISBN.getText();
        String bookLanguage = newBookLanguage.getText();

        //Every book object can have more than one copy when inserted into the database.
        for (int idcount = 0; idcount < bookNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }

        Book book = new Book(bookID, bookTitle, bookYear, imageID , IDsOfCopies, bookAuthor, bookPublisher,
                bookISBN, bookLanguage);

        //Write the book object to the databse.
        Conn.writeObject(book);

        //Reset the form.
        for(TextField field:textFieldArrayList){
            field.setText("");
        }

        //Alert Window, informs a successfull addition to the database.
        Alert alert = new Alert(Alert.AlertType.NONE, "Resource added", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();
    }

    //Passes all text fields into an array for easier manipulation.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldArrayList.add(newBookLanguage);
        textFieldArrayList.add(newBookAuthor);
        textFieldArrayList.add(newBookISBN);
        textFieldArrayList.add(newBookPublisher);
        init();
    }
}
