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

/**
 * This MyAccountController Class pairs with the "MyAccountUpdate.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class MyAccountController implements Initializable {

    @FXML
    private Pane myAccount;

    @FXML
    private TextField user_firstName;

    @FXML
    private TextField user_lastName;

    @FXML
    private TextArea user_address;

    @FXML
    private TextField user_contactNumber;

    @FXML
    private TextField user_username;

    @FXML
    private TextField user_employmentDate;

    @FXML
    private TextField user_staffNumber;

    @FXML
    private Button button_myAccountUpdate;


    @FXML
    void myAccountUpdate(MouseEvent event) throws IOException {
        Pane myAccountUpdate = FXMLLoader.load(getClass().getResource("MyAccountUpdate.fxml"));
        myAccount.getChildren().setAll(myAccountUpdate);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
