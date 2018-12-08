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
 * This UserMyAccountController Class pairs with the "UserAccount.fxml" file
 *
 *
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */


public class MembersMyAccountController {
    User activeUser;

    @FXML
    private Pane membersMyAccountPage;

    @FXML
    private TextField memberFirstName;

    @FXML
    private TextField memberLastName;

    @FXML
    private TextArea memberAddress;

    @FXML
    private TextField memberContactNumber;

    @FXML
    private TextField memberUsername;

    @FXML
    private Button saveEditMyAccountButton;

    @FXML
    private ImageView avatarSelection;

    @FXML
    private TextField memberFine;


    @FXML
    void editAccount(ActionEvent event) throws IOException {
        System.out.println(saveEditMyAccountButton.getText());

        if (saveEditMyAccountButton.getText().equals("Edit")){
            editAccountInfo();
        } else {
            showAccountInfo();
        }

    }

    void editAccountInfo(){
        memberFirstName.setDisable(false);
        memberLastName.setDisable(false);
        memberAddress.setDisable(false);
        memberContactNumber.setDisable(false);
        memberUsername.setDisable(false);
        saveEditMyAccountButton.setText("Save");
    }

    void showAccountInfo(){
        memberFirstName.setDisable(true);
        memberFirstName.setText(activeUser.getFirstName());
        memberLastName.setDisable(true);
        memberLastName.setText(activeUser.getLastName());
        memberAddress.setDisable(true);
        memberAddress.setText(activeUser.getAddress().toString());
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
