package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibrarianDashboardController implements Initializable {
    @FXML
    private BorderPane librarianDashboard;


    @FXML
    private VBox librarianControls;

    @FXML
    private ImageView avatar_img;

    @FXML
    private Button myAccountButton;

    @FXML
    private Button searchResourceButton;

    @FXML
    private Button addNewResourcesButton;

    @FXML
    private Button searchMembersButton;

    @FXML
    private Button createNewAccountButton;

    @FXML
    private Button logOutButton;

    @FXML
    public void myAccount(MouseEvent event) {
        loadUI("MyAccount");
    }

    @FXML
    void searchResource(MouseEvent event) {
        loadUI("searchResource");
    }


    @FXML
    private void addNewResource(MouseEvent event) {
        loadUI("NewResourcePanel");
    }

    @FXML
    void memberSearch(MouseEvent event) {
        loadUI("MemberSearch");

    }

    @FXML
    void createNewAccount(MouseEvent event) {
        loadUI("CreateAccount");
    }

    @FXML
    void loginPage (MouseEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("Login.fxml"));
        librarianDashboard.getChildren().setAll(loginPage);
    }

    private void loadUI (String path){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(path + ".fxml"));
            librarianDashboard.setCenter(root);
        } catch (IOException ex){
            Logger.getLogger(LibrarianDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
