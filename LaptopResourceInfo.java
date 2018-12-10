package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LaptopResourceInfo {

    @FXML
    private Pane laptopResourceInfo;

    @FXML
    private Text numberOfCopies;

    @FXML
    private Button loanItemButton;

    @FXML
    private TextField username;

    @FXML
    private ImageView newBookImage;

    @FXML
    private Text laptopTitle;

    @FXML
    private Text laptopYear;

    @FXML
    private Text laptopManufacturer;

    @FXML
    private Text laptopModel;

    @FXML
    private Text laptopOS;

    @FXML
    private Text uniqueID;

    @FXML
    void loanItem(ActionEvent event) {

    }

}
