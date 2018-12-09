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

    String imageID;

    @FXML
    private Pane createAccount;

    @FXML
    private TextField newUsername;

    @FXML
    private TextField newFirstName;

    @FXML
    private TextField newLastName;

    @FXML
    private TextField newHouseName;

    @FXML
    private TextField newStreetName;

    @FXML
    private TextField newCity;

    @FXML
    private TextField newPostCode;

    @FXML
    private TextField newPhoneNum;

    @FXML
    private TextField newEmployDate;

    @FXML
    private TextField newStaffNumber;

    @FXML
    private Button createNewAccountButton;

    @FXML
    private RadioButton avatarCat;

    @FXML
    private ImageView avatarCatImage;

    @FXML
    private ToggleGroup selectAvatar;

    @FXML
    private RadioButton avatarGhost;

    @FXML
    private ImageView avatarGhostImage;

    @FXML
    private RadioButton avatarBird;

    @FXML
    private ImageView avatarBirdImage;

    @FXML
    private RadioButton avatarFish;

    @FXML
    private ImageView avatarFishImage;

    @FXML
    private RadioButton avatarMonster;

    @FXML
    private ImageView avatarMonsterImage;

    @FXML
    private Button avatarDraw;

    @FXML
    void setCatAvatar(ActionEvent event) {
        imageID = avatarCat.getId();
    }

    @FXML
    void setGhostAvatar(ActionEvent event) {
        imageID = avatarGhost.getId();
    }

    @FXML
    void setBirdAvatar(ActionEvent event) {
        imageID = avatarBird.getId();
    }

    @FXML
    void setFishAvatar(ActionEvent event) {
        imageID = avatarFish.getId();
    }

    @FXML
    void setMonsterAvatar(ActionEvent event) {
        imageID = avatarMonster.getId();
    }

    /**
     * Opens Avatar.fxml for users to draw their own avatar and sets it as the
     * @param event - when 'createNewAccountButton' is pushed this event happens.
     * @throws IOException
     */
    @FXML
    void setCustomAvatar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Avatar.fxml"));
        Parent rootAvatar = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootAvatar, 500, 500));
        stage.show();
        //imageID =
    }

    @FXML
    void createNewAccount(ActionEvent event) {

        String userName = newUsername.getText();
        String userFirstName = newFirstName.getText();
        String userLastName = newLastName.getText();
        String userPhoneNum = newPhoneNum.getText();
        String houseName = newHouseName.getText();
        String streetName = newStreetName.getText();
        String city = newCity.getText();
        String postCode = newPostCode.getText();
        String address = houseName + streetName + city + postCode;
        String employDate = newEmployDate.getText();
        int staffNum = Integer.parseInt(newStaffNumber.getText()) ;

//        if (newStaffNumber != null && !newEmployDate.equals(null)){
//            Librarian librarian = new Librarian(userName, userFirstName, userLastName, userPhoneNum, imageID, address,
//                    employDate, staffNum);
//            System.out.println(Conn.writeObject(librarian));
//        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
