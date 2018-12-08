package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This MembersMyAccountController allows library members to view and edit their information.
 *
 * @author Ronalyn Nanong and Augguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */


public class MembersMyAccountController {
    User activeUser;

    @FXML
    private Pane membersMyAccountPage;

    @FXML
    private ImageView avatarSelection;

    @FXML
    private TextField memberFirstName;

    @FXML
    private TextField memberLastName;

    @FXML
    private TextField houseNumber;

    @FXML
    private TextField streetName;

    @FXML
    private TextField cityName;

    @FXML
    private TextField postCode;

    @FXML
    private TextField memberContactNumber;

    @FXML
    private TextField memberUsername;

    @FXML
    private TextField memberFine;

    @FXML
    private Button saveEditMyAccountButton;


    /**
     * Gets the text in the button, if it reads "Edit", the editAccountInfo method is called.
     * If the text equals something else ("Save"), the showAccountInfo is called.
     * @param event when a button pressed.
     * @throws IOException
     */
    @FXML
    void editAccount(ActionEvent event) throws IOException {
        //System.out.println(saveEditMyAccountButton.getText());

        if (saveEditMyAccountButton.getText().equals("Edit")){
            editAccountInfo();
        } else {
            showAccountInfo();
        }

    }

    /**
     * Enables the text fields to allow the user to edit their information.
     * The button text is set to "Edit".
     */
    void editAccountInfo(){
        memberFirstName.setDisable(false);
        memberLastName.setDisable(false);
        houseNumber.setDisable(false);
        streetName.setDisable(false);
        cityName.setDisable(false);
        postCode.setDisable(false);
        memberContactNumber.setDisable(false);
        memberUsername.setDisable(false);
        saveEditMyAccountButton.setText("Save");
    }

    /**
     * Gets the users information and puts it into their associated text fields.
     * Disables the text field so they are uneditable.
     * The button text is set to "Edit".
     */
    void showAccountInfo(){
        memberFirstName.setDisable(true);
        memberFirstName.setText(activeUser.getFirstName());
        memberLastName.setDisable(true);
        memberLastName.setText(activeUser.getLastName());
        houseNumber.setDisable(true);
        //houseNumber.setText(activeUser.getHouseName());
        streetName.setDisable(true);
        //streetName.setText(activeUser.getStreetName());
        cityName.setDisable(true);
        //cityName.setText(activeUser.getCity());
        postCode.setDisable(true);
        //postCode.setText(activeUser.getPostCode());
        //memberAddress.setText(activeUser.getAddress().toString());
        memberContactNumber.setDisable(true);
        memberContactNumber.setText(activeUser.getPhone());
        memberUsername.setDisable(true);
        memberUsername.setText(activeUser.getUserName());
        saveEditMyAccountButton.setText("Edit");

    }

    void setActiveUser(User user){
        this.activeUser = user;
    }

}
