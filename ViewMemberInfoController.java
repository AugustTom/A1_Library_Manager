package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This ViewMemberInfoController Class pairs with the "ViewMemberInfo.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class ViewMemberInfoController implements Initializable {

    User activeUser;

    @FXML
    private Pane viewMemberInfoPage;

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
    private TextField memberBalance;

    @FXML
    private TextField updateBalance;

    @FXML
    private Button saveEditInfoButton;

    @FXML
    private Button updateBalanceButton;

    @FXML
    private ListView<?> memberBorrowedResources;

    @FXML
    private ListView<?> memberRequestedResources;

    @FXML
    void calculateBalance(ActionEvent event) {

    }

    @FXML
    void saveEditInfo(ActionEvent event) {
        if (saveEditInfoButton.getText().equals("Edit Info")){
            editAccountInfo();
        } else {
            showAccountInfo();
        }

    }

    /**
     * Enables the text fields to allow the user to edit their information.
     * The button text is set to "Save".
     */
    void editAccountInfo(){
        memberFirstName.setDisable(false);
        memberLastName.setDisable(false);
        houseNumber.setDisable(false);
        streetName.setDisable(false);
        cityName.setDisable(false);
        postCode.setDisable(false);
        memberContactNumber.setDisable(false);
        updateBalance.setDisable(false);
        saveEditInfoButton.setText("Save");
    }

    void showAccountInfo(){
        memberFirstName.setDisable(true);
        //memberFirstName.setText(activeUser.getFirstName());
        memberLastName.setDisable(true);
        //memberLastName.setText(activeUser.getFirstName());
        houseNumber.setDisable(true);
        streetName.setDisable(true);
        cityName.setDisable(true);
        postCode.setDisable(true);
        memberContactNumber.setDisable(true);
        updateBalance.setDisable(true);


        // TODO : check for changes in each of the fields and only pass them to the writeObject
        Conn.writeObject(new User(memberUsername.getText(), memberFirstName.getText(),memberLastName.getText(),
                memberContactNumber.getText(), Double.parseDouble(updateBalance.getText()), activeUser.avatarID,
                new Address(Conn.getNextAvailableID("address"),houseNumber.getText(),streetName.getText(), cityName.getText(), postCode.getText())));

        System.out.println("User account updated");
        saveEditInfoButton.setText("Edit Info");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    /**
     * This method loads the user attributes
     */
    private void loadUserInfo() {
        memberFirstName.setText(activeUser.getFirstName());
        memberLastName.setText(activeUser.getFirstName());
        houseNumber.setText(activeUser.getAddress().getHouseName());
        streetName.setText(activeUser.getAddress().getStreetName());
        cityName.setText(activeUser.getAddress().getCity());
        postCode.setText(activeUser.getAddress().getPostCode());
        memberContactNumber.setText(activeUser.getPhone());
        memberUsername.setText(activeUser.getUserName());
        memberUsername.setText(activeUser.getUserName());
        memberBalance.setText(String.valueOf(activeUser.getBalance()));
    }

    public void setActiveUser(User selectedUser) {
        System.out.println("Loading user into info class");
        loadUserInfo();

    }
}
