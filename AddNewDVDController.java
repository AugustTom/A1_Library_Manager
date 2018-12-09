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
 * This AddNewDVDController Class pairs with the "AddNewDVD.fxml" file
 *
 *
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewDVDController extends AddNewSuperclassController{

    File imageFile; //Stores path to resource image.

    @FXML
    private Pane addNewDVDPage;
    @FXML
    private TextField newDVDDirector;

    @FXML
    private TextField newDVDRunTime;

    @FXML
    private TextField newDVDLanguage;

    @FXML
    private TextField newDVDSubtitleLanguages;
    
    /**
     * This method adds a new DVD to the database
     * <br>
     * It also has a contructor that initialises a DVD object
     * @param dvdID - ID of a DVD
     * @param dvdTitle - title of a DVD
     * @param dvdYear - year in which the DVD was released
     * @param IDsOfCopies - IDs of DVD copies
     * @param dvdDirector - director of a DVD
     * @param dvdRuntime - runtime of a DVD
     * @param dvdSubtitleLanguages - languages of the subtitles of a DVD
     * @param dvdLanguage - language of a DVD
     */

    @FXML
    void addNewDVD(ActionEvent event) {
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

        System.out.println("adding new dvd");
        int dvdID = Conn.getNextAvailableID("dvd");
        String dvdTitle = titleField.getText();
        int dvdYear = Integer.parseInt(yearField.getText());
        int dvdNumOfCopies = Integer.parseInt(numOfCopiesField.getText());
        int dvdDuration = Integer.parseInt(loanDurationField.getText());

        String dvdDirector  = newDVDDirector.getText();
        int dvdRuntime = Integer.parseInt(newDVDRunTime.getText());
        String[] dvdSubtitleLanguages = newDVDSubtitleLanguages.getText().split(",");
        String dvdLanguage = newDVDLanguage.getText();

        for (int idcount = 0; idcount < dvdNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }


        DVD dvd = new DVD (dvdID, dvdTitle, dvdYear, "1nsn", IDsOfCopies, dvdDirector, dvdRuntime,
                 dvdSubtitleLanguages, dvdLanguage);
        Conn.writeObject(dvd);
        
        //Alert Window
        Alert alert = new Alert(Alert.AlertType.NONE, "Resource added", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldArrayList.add(newDVDLanguage);
        textFieldArrayList.add(newDVDRunTime);
        textFieldArrayList.add(newDVDDirector);
        textFieldArrayList.add(newDVDSubtitleLanguages);
        init();
    }
}

