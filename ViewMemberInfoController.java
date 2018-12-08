package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewMemberInfoController implements Initializable {

    @FXML
    private Pane viewMemberInfoPage;

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
    private TextField memberUsername;

    @FXML
    private TextField memberFine;

    @FXML
    private Button saveEditMyAccountButton;

    @FXML
    private ListView<?> memberBorrowedResources;

    @FXML
    private ListView<?> memberRequestedResources;


    @FXML
    void editMemberInfo(ActionEvent event) throws IOException {
        Pane updateMembersInfoPage = FXMLLoader.load(getClass().getResource("UpdateMemberInfo.fxml"));
        viewMemberInfoPage.getChildren().setAll(updateMembersInfoPage);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
