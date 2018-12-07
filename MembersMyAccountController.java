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

/**
 * This UserMyAccountController Class pairs with the "UserAccount.fxml" file
 *
 *
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */


public class MembersMyAccountController {

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
    private Button editMyAccountButton;

    @FXML
    private ImageView avatarSelection;

    @FXML
    private TextField memberFine;

    @FXML
    void editAccount(ActionEvent event) throws IOException {
        Pane updateLibrarianMyAccountPage = FXMLLoader.load(getClass().getResource("MembersMyAccountUpdate.fxml"));
        membersMyAccountPage.getChildren().setAll(updateLibrarianMyAccountPage);

    }

}
