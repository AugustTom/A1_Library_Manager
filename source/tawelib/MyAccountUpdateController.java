package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyAccountUpdateController implements Initializable {
    @FXML
    private Pane myAccountUpdate;

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

    @FXML
    void myAccount(MouseEvent event) throws IOException {
        Pane myAccount = FXMLLoader.load(getClass().getResource("tawelib/MyAccount.fxml"));
        myAccountUpdate.getChildren().setAll(myAccount);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
