package sample;

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
    private BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb){;

    }

    @FXML
    private SplitPane librarianDashboard;

    @FXML
    private VBox user_librarianDashboard;

    @FXML
    private ImageView avatar_img;

    @FXML
    private Button button_myAccount;

    @FXML
    private Button button_resources;

    @FXML
    private Button button_addNewResources;

    @FXML
    private Button button_findMember;

    @FXML
    private Button button_createNewAccount;

    @FXML
    private Button button_logOut;



    @FXML
    private void addNewResource(MouseEvent event) {
        loadUI("NewResourcePanel");
    }

    @FXML
    void createNewAccount(MouseEvent event) {
        loadUI("CreateAccount");

    }

    @FXML
    void memberSearch(MouseEvent event) {
        loadUI("MemberSearch");

    }

    @FXML
    void logOut(MouseEvent event) {

    }

    @FXML
    public void myAccount(MouseEvent event) {
        loadUI("MyAccount");
    }

    @FXML
    void resources(MouseEvent event) {
        loadUI("Resources");

    }

    private void loadUI (String path){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(path + ".fxml"));
            borderPane.setCenter(root);
        } catch (IOException ex){
            Logger.getLogger(LibrarianDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
