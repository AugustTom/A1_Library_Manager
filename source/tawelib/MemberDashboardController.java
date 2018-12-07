package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MemberDashboardController implements Initializable {

    @FXML
    private BorderPane memberDashboard;

    @FXML
    private VBox librarianControls;

    @FXML
    private ImageView avatar_img;

    @FXML
    private Button myAccountButton;

    @FXML
    private Button resourcesButton;

    @FXML
    private Button addNewResourcesButton;

    @FXML
    private Button searchMembersButton;

    @FXML
    private Button logOutButton;

    @FXML
    void myAccount(MouseEvent event) {
        loadUI("MembersMyAccount");
    }

    @FXML
    void searchResource(MouseEvent event) {
        loadUI("SearchResource");
    }

    @FXML
    void viewRequested(MouseEvent event) {
        loadUI("ViewResources");
    }

    @FXML
    void viewResources(MouseEvent event) {
        loadUI("ViewResources");
    }

    @FXML
    void loginPage (MouseEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("login.fxml"));
        memberDashboard.getChildren().setAll(loginPage);
    }

    private void loadUI (String path){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(path + ".fxml"));
            memberDashboard.setCenter(root);
        } catch (IOException ex){
            Logger.getLogger(MemberDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
