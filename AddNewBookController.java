package tawelib;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This AddNewBookController Class pairs with the "AddNewBook.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewBookController extends AddNewSuperclassController {


    @FXML
    private Pane addNewBookPage;

    @FXML
    private TextField newBookPublisher;

    @FXML
    private TextField newBookISBN;

    @FXML
    private TextField newBookAuthor;

    @FXML
    private TextField newBookLanguage;
    
    /**
     * This method adds a new book to the database
     * <br>
     * It contains a constructor to initialise a book object
     * @param bookID - the ID of a book
     * @param bookTitle - the title of a book
     * @param bookYear - the year in which the book was released
     * @param IDsOfCopies - the IDs of the copies of a book
     * @param bookAuthor - the author of a book
     * @param bookPublisher - the publisher of a book
     * @param bookISBN - the ISBN of a book
     * @param bookLanguage - the language of a book
     * @param bookLoanDuration - the loan duration of a book
     * @param bookNumOfCopies - the number of copies of a book
     * @throws IOException
     */
    
    @FXML
    void addNewBook(ActionEvent event) throws IOException {
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);


        int bookID = Conn.getNextAvailableID("book");
        String bookTitle = titleField.getText();
        int bookYear = Integer.parseInt(yearField.getText());
        int bookNumOfCopies = Integer.parseInt(numOfCopiesField.getText());
        int bookLoanDuration = Integer.parseInt(loanDurationField.getText());

        String bookPublisher = newBookPublisher.getText();
        String bookISBN = newBookISBN.getText();
        String bookAuthor = newBookAuthor.getText();
        String bookLanguage = newBookLanguage.getText();

        for (int idcount = 0; idcount < bookNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }


        Book book = new Book(bookID, bookTitle, bookYear, "1nsn", IDsOfCopies, bookAuthor, bookPublisher,
                bookISBN, bookLanguage);
        Conn.writeObject(book);
        for(TextField field:textFieldArrayList){
            field.setText("");
        }


        //Alert Window
        Alert alert = new Alert(Alert.AlertType.NONE, "Resource added", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldArrayList.add(newBookLanguage);
        textFieldArrayList.add(newBookAuthor);
        textFieldArrayList.add(newBookISBN);
        textFieldArrayList.add(newBookPublisher);
        init();



    }
}
