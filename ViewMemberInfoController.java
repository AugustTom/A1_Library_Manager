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

public class ViewMemberInfoController implements Initializable {

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
        if (saveEditInfoButton.getText().equals("Edit")){
            editAccountInfo();
        } else {
            showAccountInfo();
        }
    }

    void editAccountInfo(){
        memberFirstName.setDisable(false);
        memberLastName.setDisable(false);
        houseNumber.setDisable(false);
        streetName.setDisable(false);
        cityName.setDisable(false);
        postCode.setDisable(false);
        memberContactNumber.setDisable(false);
        updateFine.setDisable(false);
        memberUsername.setDisable(false);
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
        //memberContactNumber.setText(activeUser.getFirstName());
        updateFine.setDisable(true);
        //memberFine.setText(activeUser.getFirstName());
        saveEditInfoButton.setText("Edit");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
