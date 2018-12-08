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


    private ArrayList<TextField> textFieldArrayList = new ArrayList<>();

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
    void addNewBook(ActionEvent event) throws IOException {


        ArrayList<Integer> IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

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


        Book book = new Book(bookID, bookTitle, bookYear, "1nsn", IDsOfCopies, bookAuthor, bookPublisher,
                bookISBN, bookLanguage);
        System.out.println(Conn.writeObject(book));


        //Alert Window
        Alert alert = new Alert(Alert.AlertType.NONE, "Resource added", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();
    }

    public void inputCheck(){
               addNewBookButton.disableProperty().bind(Bindings.createBooleanBinding(
                       () -> {
                           boolean check = true;
                           for (TextField textField: textFieldArrayList){
                               check = check && textField.getText().isEmpty();
                           }
                           return check;
                       }));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        inputCheck();
        textFieldArrayList.add(newBookLanguage);
        textFieldArrayList.add(newBookTitle);
        textFieldArrayList.add(newBookAuthor);
        textFieldArrayList.add(newBookCopies);
        textFieldArrayList.add(newBookID);
        textFieldArrayList.add(newBookISBN);
        textFieldArrayList.add(newBookLoanDuration);
        textFieldArrayList.add(newBookPublisher);
        textFieldArrayList.add(newBookYear);


        for(TextField textField:textFieldArrayList)
        {
            textField.textProperty().addListener((observable) -> {
                inputCheck();
            });
        }
    }
}
