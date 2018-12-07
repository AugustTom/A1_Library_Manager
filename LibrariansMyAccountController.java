package tawelib;

import javafx.event.ActionEvent;
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

    @FXML
    private Pane librarianMyAccountPage;

    @FXML
    private Button editMyAccountButton;

    @FXML
    private TextField user_staffNumber;

    @FXML
    private TextField user_staffNumber1;

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
    void editAccount(ActionEvent event) throws IOException {
        Pane updateLibrarianMyAccountPage = FXMLLoader.load(getClass().getResource("LibrariansMyAccountUpdate.fxml"));
        librarianMyAccountPage.getChildren().setAll(updateLibrarianMyAccountPage);

    }

    @FXML
    void myAccount(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
