package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This CreateAccountController Class pairs with the "CreateAccount.fxml" file
 *
 *
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class CreateAccountController implements Initializable {

    @FXML
    private Pane createAccount;

    @FXML
    private TextField newUserUsername;

    @FXML
    private TextField newUserFirstName;

    @FXML
    private TextField newUserLastName;

    @FXML
    private TextField newUserContactNo;

    @FXML
    private TextField newUserAddress;

    @FXML
    private TextField newUserEmployDate;

    @FXML
    private TextField newUserStaffNumber;

    @FXML
    private Button createNewAccountButton;

    @FXML
    private RadioButton avatarCat;

    @FXML
    private ToggleGroup selectAvatar;

    @FXML
    private RadioButton avatarGhost;

    @FXML
    private RadioButton avatarCanvas;

    @FXML
    private ImageView avatarDraw;

    @FXML
    private RadioButton avatarBird;

    @FXML
    private RadioButton avatarFish;

    @FXML
    private RadioButton avatarMonster;

    @FXML
    void setBirdAvatar(ActionEvent event) {

    }

    @FXML
    void setCatAvatar(ActionEvent event) {

    }

    @FXML
    void setFishAvatar(ActionEvent event) {

    }

    @FXML
    void setGhostAvatar(ActionEvent event) {

    }

    @FXML
    void setMonsterAvatar(ActionEvent event) {

    }

    /**
     * Opens Avatar.fxml for users to draw their own avatar.
     * @param event - when 'createNewAccountButton' is pushed this event happens.
     * @throws IOException
     */
    @FXML
    void setCustomAvatar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Avatar.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
