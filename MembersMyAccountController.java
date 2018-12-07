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

public class MembersMyAccountController {

    @FXML
    private Pane membersMyAccountPage;

    @FXML
    private TextField userFirstName;

    @FXML
    private TextField userLastName;

    @FXML
    private TextArea userAddress;

    @FXML
    private TextField userContactNumber;

    @FXML
    private TextField userUsername;

    @FXML
    private Button editMyAccountButton;

    @FXML
    private ImageView avatarSelection;

    @FXML
    void editAccount(ActionEvent event) throws IOException {
        Pane updateLibrarianMyAccountPage = FXMLLoader.load(getClass().getResource("MembersMyAccountUpdate.fxml"));
        membersMyAccountPage.getChildren().setAll(updateLibrarianMyAccountPage);

    }

}
