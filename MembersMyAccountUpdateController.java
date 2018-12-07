package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MembersMyAccountUpdateController implements Initializable {

    @FXML
    private Pane updateMembersMyAccountPage;

    @FXML
    private TextField memberFirstNameUpdate;

    @FXML
    private TextField memberLastNameUpdate;

    @FXML
    private TextArea memberAddressUpdate;

    @FXML
    private TextField memberContactNoUpdate;

    @FXML
    private TextField memberUsernameUpdate;

    @FXML
    private Button saveMyAccountButton;

    @FXML
    private ImageView avatarSelection;

    @FXML
    private TextField memberFine;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    void saveMyAccountUpdates(ActionEvent actionEvent) throws IOException {
        Pane membersMyAccountPage = FXMLLoader.load(getClass().getResource("MembersMyAccount.fxml"));
        updateMembersMyAccountPage.getChildren().setAll(membersMyAccountPage);
    }

}
