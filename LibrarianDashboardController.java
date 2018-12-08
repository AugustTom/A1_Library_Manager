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
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This LibrarianDashboardController Class pairs with the "LibrarianDashboard.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class LibrarianDashboardController implements Initializable {

    private Librarian activeUser;

    @FXML
    private BorderPane librarianDashboard;

    @FXML
    private Text username;

    @FXML
    private VBox librarianControls;

    @FXML
    private ImageView avatarImg;

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
        Parent root = null;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LibrariansMyAccount.fxml"));
            root = loader.load();
            librarianDashboard.setCenter(root);
            LibrariansMyAccountController  controller = loader.getController();
            controller.setActiveUser(activeUser);
            System.out.println("active user passed");

        } catch (IOException ex){
            Logger.getLogger(LibrarianDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void loadUser(Librarian user) {
        this.activeUser = user;
        username.setText("Hello, " + user.getFirstName());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}