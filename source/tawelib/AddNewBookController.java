package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This AddNewBookController Class pairs with the "AddNewBook.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewBookController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
