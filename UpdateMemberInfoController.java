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

public class UpdateMemberInfoController {

    @FXML
    private Pane updateMembersInfoPage;

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
    private Button saveEditMyAccountButton;

    @FXML
    private TextField memberUsername;

    @FXML
    private TextField memberFine;

    @FXML
    private TextField memberFine1;

    @FXML
    private Button updateFineButton;

    @FXML
    void calculateFine(ActionEvent event) {

    }

    @FXML
    void saveMemberInfoUpdates(ActionEvent event) throws IOException {
        Pane viewMemberInfoPage = FXMLLoader.load(getClass().getResource("ViewMemberInfo.fxml"));
        updateMembersInfoPage.getChildren().setAll(viewMemberInfoPage);

    }

}
