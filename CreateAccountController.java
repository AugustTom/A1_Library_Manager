package tawelib;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    //Stores all textfields for easy reset.
    private ArrayList<TextField> textFieldArrayList = new ArrayList<>();


    //The following attributes correspond to the fxml entry fields, they are what make up an account.
    private String imageID;

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
    void setCatAvatar() {
        imageID = avatarCat.getId();
    }

    /**
     * set method for the ghost avatar
     */
    @FXML
    void setGhostAvatar() {
        imageID = avatarGhost.getId();
    }
    
    /**
     * Set method for the bird avatar
     */
    @FXML
    void setBirdAvatar() {
        imageID = avatarBird.getId();
    }
    
    /**
     * Set method for fish avatar
     */
    @FXML
    void setFishAvatar() {
        imageID = avatarFish.getId();
    }
    
    /**
     * Set method for the monster avatar
     */
    @FXML
    void setMonsterAvatar() {
        imageID = avatarMonster.getId();
    }

    /**
     * Opens Avatar.fxml for users to draw their own avatar and sets it as the
     * @param event - when 'createNewAccountButton' is pushed this event happens.
     * @throws IOException - when no file of that location can be found
     */
    @FXML
    void setCustomAvatar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Avatar.fxml"));

        Parent rootAvatar = fxmlLoader.load();
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
    void createNewAccount() {

        String userName = newUsername.getText();
        String userFirstName = newFirstName.getText();
        String userLastName = newLastName.getText();
        String userPhoneNum = newPhoneNum.getText();
        String houseName = newHouseName.getText();
        String streetName = newStreetName.getText();
        String city = newCity.getText();
        String postCode = newPostCode.getText();

        Address address1 = new Address(Conn.getNextAvailableID("address"), houseName,streetName,city,postCode);

        //Validate that you are creating a user account.
        if (newStaffNumber.getText().isEmpty() && newEmployDate.getText().isEmpty()){
            User user = new User(userName, userFirstName, userLastName, userPhoneNum, 0.0,imageID, address1);
            System.out.println("new user created!");
            Conn.writeObject(user);

        // Otherwise you are creating a librarian.
        } else {
            Librarian user = new Librarian(userName, userFirstName, userLastName, userPhoneNum, 0.0,imageID,
                    address1,newEmployDate.getText(), Integer.parseInt(newStaffNumber.getText()));
            System.out.println("new librarian created!");
            Conn.writeObject(user);
        }

        Alert alert = new Alert(Alert.AlertType.NONE, "New user created", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Node node : createAccount.getChildren()) {
            if (node instanceof TextField) {
                textFieldArrayList.add((TextField)node);
            }
        }
    }

    //Check that all required fields are filled.
    private void inputCheck(){
        createNewAccountButton.disableProperty().bind(Bindings.createBooleanBinding(
                () -> {
                    boolean check = true;
                    for (TextField textField: textFieldArrayList){
                        check = check && textField.getText().isEmpty();
                    }
                    return check;
                }));
    }

    private void addListeners(){

        for(TextField textField:textFieldArrayList)
        {
            textField.textProperty().addListener((observable) -> {
                inputCheck();
            });
        }
    }
}
