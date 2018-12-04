package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewDVDController implements Initializable {

    @FXML
    private Pane addNewDVD;

    @FXML
    private TextField newResource_id;

    @FXML
    private TextField newResource_title;

    @FXML
    private TextField newResource_year;

    @FXML
    private TextField newResource_numberOfCopies;

    @FXML
    private TextField newResource_loanDuration;

    @FXML
    private Button button_browseImage;

    @FXML
    private TextField newResource_image;

    @FXML
    private TextField newResource_director;

    @FXML
    private TextField newResource_runtime;

    @FXML
    private TextField newResource_language;

    @FXML
    private TextField newResource_subtitleLanguages;

    @FXML
    private Button button_addNewDVD;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
