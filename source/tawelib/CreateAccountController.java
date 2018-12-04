package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {

    @FXML
    private TextField newUser_username;

    @FXML
    private TextField newUser_firstName;

    @FXML
    private TextField newUser_astName;

    @FXML
    private TextField newUser_ContactNumber;

    @FXML
    private TextField newUser_Address;

    @FXML
    private TextField newUser_employmentDate;

    @FXML
    private TextField newUser_staffNumber;

    @FXML
    private Button button_createAccount;

    @FXML
    private RadioButton rb_sittingCat;

    @FXML
    private RadioButton rb_ghost;

    @FXML
    private RadioButton rb_monster;

    @FXML
    private RadioButton rb_bird;

    @FXML
    private RadioButton rb_fish;

    @FXML
    private RadioButton rb_canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
