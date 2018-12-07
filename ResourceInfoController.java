package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ResourceInfoController implements Initializable {

    @FXML
    private Pane ResourceInfoPage;

    @FXML
    private Text id;

    @FXML
    private Text Title;

    @FXML
    private Text year;

    @FXML
    private Text numberOfCopies;

    @FXML
    private Text loanDuration;

    @FXML
    private ImageView newBookImage;

    @FXML
    private Text author;

    @FXML
    private Text publisher;

    @FXML
    private Text isbn;

    @FXML
    private Text language;

    @FXML
    private Text director;

    @FXML
    private Text runtime;

    @FXML
    private Text subtitleLanguages;

    @FXML
    private Text brand;

    @FXML
    private Text model;

    @FXML
    private Text operatingSystem;

    @FXML
    private Button loanItemButton;

    @FXML
    private Text username;

    @FXML
    void loanItem(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
