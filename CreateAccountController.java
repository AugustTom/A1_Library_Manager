package tawelib;

import javafx.embed.swing.SwingFXUtils;
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

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This CreateAccountController Class pairs with the "CreateAccount.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
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

    /**
     * set method for the cat avatar
     */
    @FXML
    void setCatAvatar(ActionEvent event) {
        imageID = avatarCat.getId();
    }

    /**
     * set method for the ghost avatar
     */
    @FXML
    void setGhostAvatar(ActionEvent event) {
        imageID = avatarGhost.getId();
    }
    
    /**
     * Set method for the bird avatar
     */
    @FXML
    void setBirdAvatar(ActionEvent event) {
        imageID = avatarBird.getId();
    }
    
    /**
     * Set method for fish avatar
     */
    @FXML
    void setFishAvatar(ActionEvent event) {
        imageID = avatarFish.getId();
    }
    
    /**
     * Set method for the monster avatar
     */
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
        AvatarController avatarController = fxmlLoader.getController();
        String username = newUsername.getText();
        avatarController.setUsername(username);
        Stage stage = new Stage();
        stage.setScene(new Scene(rootAvatar, 500, 500));
        stage.showAndWait();
        imageID = "avatar" + username;
    }
    
    /**
     * This method creates a new account for either a user or a librarian
     * <br>
     * If the account has no staff number and no employment date this method creates a user account
     * <br>
     * Otherwise this method creates a librarian account
     */
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

        Address address1 = new Address(Conn.getNextAvailableID("address"), houseName,streetName,city,postCode);


        if (newStaffNumber.getText().isEmpty() && newEmployDate.getText().isEmpty()){
            User user = new User(userName, userFirstName, userLastName, userPhoneNum, 0.0,imageID, address1);
            System.out.println("new user created!");
            Conn.writeObject(user);
        }
        else {
            Librarian user = new Librarian(userName, userFirstName, userLastName, userPhoneNum, 0.0,imageID,
                    address1,newEmployDate.getText(), Integer.parseInt(newStaffNumber.getText()));
            System.out.println("new librarian created!");
            Conn.writeObject(user);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
