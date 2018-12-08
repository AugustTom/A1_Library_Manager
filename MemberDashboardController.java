package tawelib;

import com.sun.org.apache.bcel.internal.generic.FMUL;
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

/**
 * This UserDashboardController Class pairs with the "UserDashboard.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class MemberDashboardController implements Initializable {

    private User activeUser;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "ViewResources.fxml"));
        ViewResourcesController controller = loader.getController();
        controller.setActiveUser(activeUser);
        controller.setViewType("Requested");
    }

    @FXML
    void viewBorrowed(MouseEvent event) {
        loadUI("ViewResources");
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "ViewResources.fxml"));
        ViewResourcesController controller = loader.getController();
        controller.setActiveUser(activeUser);
        controller.setViewType("Borrowed");
    }

    @FXML
    void loginPage (MouseEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("Login.fxml"));
        memberDashboard.getChildren().setAll(loginPage);
    }

    private void loadUI (String path){
        Parent root = null;

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path + ".fxml"));
            root = loader.load();
            memberDashboard.setCenter(root);
            if (path.equals("ViewResources")){

            } else if (path.equals("SearchResources")){
                SearchResourceController controller = loader.getController();
                controller.setActiveUser(activeUser);
            } else if(path.equals("MyAccount")){
                MembersMyAccountController controller = loader.getController();
                controller.setActiveUser(activeUser);
            } else {
                MembersMyAccountController controller = loader.getController();
                controller.setActiveUser(activeUser);
            }

        } catch (IOException ex){
            Logger.getLogger(MemberDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void setActiveUser(User user) {

        activeUser = user;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
         loadUI("MembersMyAccount");

    }
}
