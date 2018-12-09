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

public class AddNewSuperclassController implements Initializable {

    File imageFile; //Stores path to resource image.

    String pathToImage;

    @FXML
     TextField titleField;

    @FXML
     TextField yearField;

    @FXML
    TextField numOfCopiesField;

    @FXML
    TextField loanDurationField;

    @FXML
    Button addNewButton;

    @FXML
    ImageView newImage;

    @FXML
    Button browseImageButton;


    ArrayList<TextField> textFieldArrayList = new ArrayList<>();
    ArrayList<Integer> IDsOfCopies = new ArrayList<>();
    
    /**
     * This method gets a file image from the given directory if available
     */ 
    
    @FXML
    void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));

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
        newImage.setImage(image);

        pathToImage = imageFile.getName();
    }
    
    /**
     * set method for IDs of copies
     * @param IDsOfCopies
     */



    void setIDsOfCopies(int copies) {
        for (int i = 0; i < copies; i++){
            IDsOfCopies.add(Conn.getNextAvailableID("copy"));
        }
    }

    /**
     * Disable button when adding a resource
     * @return boolean check
     */
    
    public void inputCheck(){
        addNewButton.disableProperty().bind(Bindings.createBooleanBinding(
                () -> {
                    boolean check = true;
                    for (TextField textField: textFieldArrayList){
                        check = check && textField.getText().isEmpty();
                    }
                    return check;
                }));
    }

    void addListeners(){

        for(TextField textField:textFieldArrayList)
        {
            textField.textProperty().addListener((observable) -> {
                inputCheck();
            });
        }
    }
    
    void init(){
        textFieldArrayList.add(titleField);
        textFieldArrayList.add(numOfCopiesField);
        textFieldArrayList.add(loanDurationField);
        textFieldArrayList.add(yearField);
        inputCheck();
        addListeners();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
