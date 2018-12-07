package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
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

public class AddNewBookController implements Initializable {

    File imageFile; //Stores path to resource image.

    @FXML
    private Pane addNewBookPage;

    @FXML
    private TextField newBookID;

    @FXML
    private TextField newBookTitle;

    @FXML
    private TextField newBookYear;

    @FXML
    private TextField newBookCopies;

    @FXML
    private TextField newBookLoanDuration;

    @FXML
    private TextField newBookPublisher;

    @FXML
    private TextField newBookISBN;

    @FXML
    private TextField newBookAuthor;

    @FXML
    private TextField newBookLanguage;

    @FXML
    private Button addNewBookButton;

    @FXML
    private ImageView newBookImage;

    @FXML
    private Button browseImageButton;

    @FXML
    void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Open directory from existing directory
        if(imageFile != null){
            File existDirectory = imageFile.getParentFile();
            fileChooser.setInitialDirectory(existDirectory);
        }

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        imageFile = fileChooser.showOpenDialog(null);

        Image image = new Image(imageFile.toURI().toString());

        newBookImage.setImage(image);

    }

    @FXML
    void addNewBook(MouseEvent event) {

        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

        System.out.println("adding new book");
        int bookID = Integer.parseInt(newBookID.getText());
        String bookTitle = newBookTitle.getText();
        int bookYear = Integer.parseInt(newBookYear.getText());
        int bookNumOfCopies = Integer.parseInt(newBookCopies.getText());
        int bookLoanDuration = Integer.parseInt(newBookLoanDuration.getText());

        String bookPublisher = newBookPublisher.getText();
        String bookISBN = newBookISBN.getText();
        String bookAuthor = newBookAuthor.getText();
        String bookLanguage = newBookLanguage.getText();
        for (int idcount = 0; idcount < bookNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }


        Book book = new Book (bookID, bookTitle, bookYear, "1nsn", IDsOfCopies, bookAuthor, bookPublisher,
                bookISBN, bookLanguage);
        Conn.writeObject(book);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
