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

public class LibrariansMyAccountUpdateController implements Initializable {

    @FXML
    private Pane updateLibrarianMyAccountPage;

    @FXML
    private Button saveAccountUpdatesButton;

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
    private TextField user_staffNumber1;

    @FXML
    private TextField user_staffNumber;

    @FXML
    void myAccount(MouseEvent event) {

    }

    @FXML
    void saveAccountUpdates(ActionEvent event) throws IOException {
        Pane librarianMyAccountPage = FXMLLoader.load(getClass().getResource("LibrariansMyAccount.fxml"));
        updateLibrarianMyAccountPage.getChildren().setAll(librarianMyAccountPage);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
