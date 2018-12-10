package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class is paired with "ResourceInfo.fxml"
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class UserResourceInfoController implements Initializable {

    private Resources activeResource;

    @FXML
    private Pane resourceInfoPage;

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
    private Text username;

    @FXML
    void loanItem(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setResources(ArrayList<Resources> resource) {
        this.activeResource = resource.get(0);
    }
}
