package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private TextField newUser_avatarUpload;

    @FXML
    private Button newUser_browseAvatar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
