package tawelib;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This LibrariansMyAccountController allows librarians to view and edit their information.
 * @author Ronalyn Nanong and Augguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */

public class LibrariansMyAccountController{

    private Librarian activeUser;

    @FXML
    private Pane librarianMyAccountPage;

    @FXML
    private ImageView avatarSelection;

    @FXML
    private TextField librarianFirstName;

    @FXML
    private TextField librarianLastName;

    @FXML
    private TextField houseNumber;

    @FXML
    private TextField streetName;

    @FXML
    private TextField cityName;

    @FXML
    private TextField postCode;

    @FXML
    private TextField librarianContactNumber;

    @FXML
    private TextField librarianUsername;

    @FXML
    private TextField librarianEmploymentDate;

    @FXML
    private TextField librarianStaffNumber;

    @FXML
    private Button saveEditMyAccountButton;

    /**
     * When Edit button is clicked, the user's information fields are enabled allowing the user to edit the text
     * fields. The Edit button's text changes to Save, which gets the text in the text fields, i.e. any changed text
     * and sets it so the user's information is now updated.
     * @param event when a button pressed.
     * @throws IOException
     */
    @FXML
    void editAccount(Event event) throws IOException {

        if (saveEditMyAccountButton.getText().equals("Edit")){
                editAccountInfo();
        } else {
            showAccountInfo();
        }

        loadInfo();
    }
    
    /**
     * Enables the text fields to allow the user to edit their information.
     * The button text is set to "Save".
     */
    void editAccountInfo(){
        houseNumber.setDisable(false);
        streetName.setDisable(false);
        cityName.setDisable(false);
        postCode.setDisable(false);
        librarianEmploymentDate.setDisable(false);
        librarianContactNumber.setDisable(false);
        librarianFirstName.setDisable(false);
        librarianLastName.setDisable(false);
        saveEditMyAccountButton.setText("Save");
    }

    /**
     * Gets the user information and puts it into their associated text fields.
     * Disables the text field so they are uneditable.
     * The button text is set to "Edit".
     */
    void showAccountInfo(){

        librarianFirstName.setDisable(true);
        librarianLastName.setDisable(true);
        houseNumber.setDisable(true);
        streetName.setDisable(true);
        cityName.setDisable(true);
        postCode.setDisable(true);
        librarianContactNumber.setDisable(true);
        librarianUsername.setDisable(true);
        librarianEmploymentDate.setDisable(true);
        librarianStaffNumber.setDisable(true);

        Address address;
        if(!(activeUser.getAddress().getHouseName().equals(houseNumber.getText()) &&
                activeUser.getAddress().getStreetName().equals(streetName.getText()) &&
                activeUser.getAddress().getCity().equals(cityName.getText()) &&
                activeUser.getAddress().getPostCode().equals(postCode.getText()))){

            address = new Address(Conn.getNextAvailableID("address"), houseNumber.getText(),
                    streetName.getText(), cityName.getText(), postCode.getText());
        }  else {
            address = activeUser.getAddress();
        }

        //Resetting active User for this class
        activeUser = new Librarian(activeUser.getUserName(), librarianFirstName.getText(),librarianLastName.getText(),
                librarianContactNumber.getText(),0.0,  activeUser.avatarID, address, activeUser.getEmployDate(), activeUser.getStaffNum());

        //TODO reset the active user for UserDashboard
        Conn.writeObject(activeUser);

        saveEditMyAccountButton.setText("Edit");
    }

    public void setActiveUser(Librarian activeUser) {
        this.activeUser = activeUser;
        loadInfo();

    }

    private void loadInfo(){
        librarianFirstName.setText(activeUser.getFirstName());
        librarianLastName.setText(activeUser.getLastName());
        houseNumber.setText(activeUser.getAddress().getHouseName());
        streetName.setText(activeUser.getAddress().getStreetName());
        cityName.setText(activeUser.getAddress().getCity());
        postCode.setText(activeUser.getAddress().getPostCode());
        librarianContactNumber.setText(activeUser.getPhone());
        librarianUsername.setText(activeUser.getUserName());
        librarianEmploymentDate.setText(activeUser.getEmployDate());
        librarianStaffNumber.setText(String.valueOf(activeUser.getStaffNum()));
    }

}
