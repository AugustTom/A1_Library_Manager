package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MyAccountUpdateController implements Initializable {

    @FXML
    private TextField userUpdate_firstName;

    @FXML
    private TextField userUpdate_lastName;

    @FXML
    private TextArea userUpdate_Address;

    @FXML
    private TextField userUpdate_contactNumber;

    @FXML
    private Button button_saveAccountUpdate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
