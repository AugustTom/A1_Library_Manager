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

public class UpdateMemberInfoController implements Initializable {

    @FXML
    private Pane updateMembersInfoPage;

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
    private Button saveMemberInfoButton;

    @FXML
    private ImageView avatarSelection;

    @FXML
    private TextField memberFine;

    @FXML
    private TextField fineUpdate;

    @FXML
    private Button updateFineButton;

    @FXML
    void saveMemberInfoUpdates(ActionEvent event) throws IOException {
        Pane viewMemberInfoPage = FXMLLoader.load(getClass().getResource("ViewMemberInfo.fxml"));
        updateMembersInfoPage.getChildren().setAll(viewMemberInfoPage);

    }

    @FXML
    void updateFine(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
