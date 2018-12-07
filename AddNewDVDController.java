package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
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

public class AddNewDVDController implements Initializable{

    @FXML
    private Pane addNewDVDPage;

    @FXML
    private TextField newDVDID;

    @FXML
    private TextField newDVDTitle;

    @FXML
    private TextField newDVDYear;

    @FXML
    private TextField newDVDCopies;

    @FXML
    private TextField newDVDLoanDuration;

    @FXML
    private TextField newDVDDirector;

    @FXML
    private TextField newDVDRunTime;

    @FXML
    private TextField newDVDLanguage;

    @FXML
    private TextField newDVDSubtitleLanguages;

    @FXML
    private Button addNewDVDButton;

    @FXML
    private Button browseImageButton;

    @FXML
    private ImageView newDVDImage;

    @FXML
    void addNewDVD(ActionEvent event) {
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

        System.out.println("adding new dvd");
        int dvdID = Integer.parseInt(newDVDID.getText());
        String dvdTitle = newDVDTitle.getText();
        int dvdYear = Integer.parseInt(newDVDYear.getText());
        int dvdNumOfCopies = Integer.parseInt(newDVDCopies.getText());
        int dvdDuration = Integer.parseInt(newDVDLoanDuration.getText());

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

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

