package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewLaptopController implements Initializable {

    @FXML
    private Pane addNewLaptop;

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
    private TextField newResource_model;

    @FXML
    private MenuButton newResource_manufacturer;

    @FXML
    private MenuButton newResource_operatingSystem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
