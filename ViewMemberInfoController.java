package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewMemberInfoController implements Initializable {


    private User activeUser;
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
    private TextField memberFine;

    @FXML
    private TextField updateFine;

    @FXML
    private Button saveEditInfoButton;

    @FXML
    private Button updateFineButton;

    @FXML
    private ListView<?> memberBorrowedResources;

    @FXML
    private ListView<?> memberRequestedResources;

    @FXML
    void calculateFine(ActionEvent event) {

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
    private void editAccountInfo(){
        loadUserInfo();
        memberFirstName.setDisable(false);
        memberLastName.setDisable(false);
        houseNumber.setDisable(false);
        streetName.setDisable(false);
        cityName.setDisable(false);
        postCode.setDisable(false);
        memberContactNumber.setDisable(false);
        updateFine.setDisable(false);

        saveEditInfoButton.setText("Save");
    }

    private void showAccountInfo(){
        loadUserInfo();
        memberFirstName.setDisable(true);
        memberLastName.setDisable(true);
        houseNumber.setDisable(true);
        streetName.setDisable(true);
        cityName.setDisable(true);
        postCode.setDisable(true);
        memberContactNumber.setDisable(true);
        updateFine.setDisable(true);


        // TODO : check for changes in each of the fields and only pass them to the writeObject
        Conn.writeObject(new User(memberUsername.getText(), memberFirstName.getText(),memberLastName.getText(),
                memberContactNumber.getText(), Double.parseDouble(memberFine.getText()), activeUser.avatarID,
                new Address(Conn.getNextAvailableID("address"),houseNumber.getText(),streetName.getText(), cityName.getText(), postCode.getText())));

        System.out.println("User account updated");
        saveEditInfoButton.setText("Edit Info");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

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
        memberFine.setText(String.valueOf(activeUser.getBalance()));
    }


    public void setActiveUser(User searchUsers) {
        this.activeUser = searchUsers;
        loadUserInfo();
    }
}
