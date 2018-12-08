package tawelib;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibrariansMyAccountController implements Initializable {
    Librarian activeUser;

    @FXML
    private Pane librarianMyAccountPage;

    @FXML
    private Button editMyAccountButton;

    @FXML
    private TextField librarianStaffNumber;

    @FXML
    private TextField librarianEmploymentDate;

    @FXML
    private TextField userUsername;

    @FXML
    private TextArea userAddress;

    @FXML
    private TextField userContactNumber;

    @FXML
    private TextField userLastName;

    @FXML
    private TextField userFirstName;


    @FXML
    void myAccount(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        userFirstName.setText(activeUser.getFirstName());
//        userLastName.setText(activeUser.getLastName());
//        librarianEmploymentDate.setText(activeUser.getEmployDate());
//        userAddress.setText(activeUser.getAddress().toString());
//        userContactNumber.setText(activeUser.getPhone());
//        userUsername.setText(activeUser.getUserName());


    }
    @FXML
    void editAccount(Event event) throws IOException {

        if (editMyAccountButton.getText().equals("Edit")){
                editAccountInfo();
            } else {
                showAccountInfo();
            }

}

    void editAccountInfo(){
        librarianStaffNumber.setDisable(false);
        userAddress.setDisable(false);
        librarianEmploymentDate.setDisable(false);
        userContactNumber.setDisable(false);
        userFirstName.setDisable(false);
        userLastName.setDisable(false);
        userUsername.setDisable(false);
        editMyAccountButton.setText("Save");
    }

    void showAccountInfo(){
        userFirstName.setDisable(true);
        userFirstName.setText(activeUser.getFirstName());
        userLastName.setDisable(true);
        userLastName.setText(activeUser.getLastName());
        librarianEmploymentDate.setText(activeUser.getEmployDate());
        librarianEmploymentDate.setDisable(true);
        userAddress.setDisable(true);
        userAddress.setText(activeUser.getAddress().toString());
        userContactNumber.setDisable(true);
        userContactNumber.setText(activeUser.getPhone());
        userUsername.setDisable(true);
        userUsername.setText(activeUser.getUserName());
        editMyAccountButton.setText("Edit");

    }

    public void setActiveUser(Librarian activeUser) {
        this.activeUser = activeUser;
    }
}
