package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LibrarianResourceInfoController {

    @FXML
    private Pane dvdResourceInfo;

    @FXML
    private Text numberOfCopies;

    @FXML
    private Button loanItemButton;

    @FXML
    private TextField username;

    @FXML
    private ImageView newBookImage;

    @FXML
    private Text dvdTitle;

    @FXML
    private Text dvdYear;

    @FXML
    private Text dvdDirector;

    @FXML
    private Text dvdRuntime;

    @FXML
    private Text dvdLanguage;

    @FXML
    private Text uniqueID;

    @FXML
    private Text dvdSubLanguages;

    @FXML
    void loanItem(ActionEvent event) {

    }

}
