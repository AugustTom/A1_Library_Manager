package GUI;


import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This UserMyAccountController Class pairs with the "UserAccount.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */

public class UserMyAccountController implements Initializable {

    @FXML
    private Pane myAccount;

    @FXML
    private TextField userFirstName;

    @FXML
    private TextField userLastName;

    @FXML
    private TextArea userAddress;

    @FXML
    private TextField userContactNumber;

    @FXML
    private TextField userUsername;

    @FXML
    private Button myAccountUpdate;

    @FXML
    private ImageView userProfilePicture;

    @FXML
    void myAccountUpdate(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}


