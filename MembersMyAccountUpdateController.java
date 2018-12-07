package tawelib;

import javafx.event.ActionEvent;
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

public class MembersMyAccountUpdateController implements Initializable {

    @FXML
    private Pane updateMembersMyAccountPage;

    @FXML
    private Button saveAccountUpdatesButton;

    @FXML
    private ImageView userAvatar;

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

    }
    @FXML
    void saveMyAccountUpdates(ActionEvent actionEvent) throws IOException {
        Pane membersMyAccountPage = FXMLLoader.load(getClass().getResource("MembersMyAccount.fxml"));
        updateMembersMyAccountPage.getChildren().setAll(membersMyAccountPage);
    }

}
