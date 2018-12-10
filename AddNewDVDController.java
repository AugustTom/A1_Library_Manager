package tawelib;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This AddNewDVDController Class pairs with the "AddNewDVD.fxml" file,<br>
 * Handles all widgets within the fxml file and returns the appropriate values.<br>
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewDVDController extends AddNewSuperclassController{

    File imageFile; //Stores path to resource image.

    @FXML
    private Pane addNewDVDPage;

    //These text fields correspond to the editable textfields within the fxml file.
    @FXML
    private TextField newDVDDirector;

    @FXML
    private TextField newDVDRunTime;

    @FXML
    private TextField newDVDLanguage;

    @FXML
    private TextField newDVDSubtitleLanguages;

    /**
     * This method adds a new dvd to the database, it reads the input text from the
     * fxml fields and translates them into usable data which constructs a dvd object,
     * that object is then written to the Conn class which writes it as a entry to the database.
     * <br>
     * It contains a constructor to initialise a dvd object.
     * @param event
     */
    @FXML
    public void addNewDVD(ActionEvent event) {

        //Initially there is one copy
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

        //Fetches the next free resourceID so that every resource has a unique identifier in the database.
        int dvdID = Conn.getNextAvailableID("dvd");

        //Retrieves input data from fxml fields and stores them in usable variables.
        String dvdTitle = titleField.getText();
        int dvdYear = Integer.parseInt(yearField.getText());
        String imageID = "hello";
        int dvdNumOfCopies = Integer.parseInt(numOfCopiesField.getText());
        int dvdDuration = Integer.parseInt(loanDurationField.getText());
        String dvdDirector  = newDVDDirector.getText();
        int dvdRuntime = Integer.parseInt(newDVDRunTime.getText());
        String[] dvdSubtitleLanguages = newDVDSubtitleLanguages.getText().split(",");
        String dvdLanguage = newDVDLanguage.getText();

        //Every book object can have more than one copy when inserted into the database.
        for (int idcount = 0; idcount < dvdNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }

        // New dvd object is created.
        DVD dvd = new DVD (dvdID, dvdTitle, dvdYear, "1nsn", IDsOfCopies, dvdDirector, dvdRuntime,
                 dvdSubtitleLanguages, dvdLanguage);

        //Write the book object to the databse.
        Conn.writeObject(dvd);

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

        textFieldArrayList.add(newDVDLanguage);
        textFieldArrayList.add(newDVDRunTime);
        textFieldArrayList.add(newDVDDirector);
        textFieldArrayList.add(newDVDSubtitleLanguages);
        init();

    }
}

