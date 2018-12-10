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
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This UserDashboardController Class pairs with the "UserDashboard.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @author Ronalyn Lilyanne
 * @version 2.0
 * @since 09/12/2018
 */

public class MemberDashboardController implements Initializable {

    private User activeUser;

    @FXML
    private BorderPane memberDashboard;

    @FXML
    private Text username;

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
        loadUI("MembersMyAccount", 0);
    }

    @FXML
    void searchResource(MouseEvent event) { loadUI("SearchResource", 0); }

    @FXML
    void viewResource(MouseEvent event) { loadUI("ViewResource",0); }

/**
 * @throws IOException
 */
    @FXML
    void loginPage (MouseEvent event) throws IOException {
        Parent loginPage = FXMLLoader.load(getClass().getResource("Login.fxml"));
        memberDashboard.getChildren().setAll(loginPage);
    }

    //Type is for what kind of resource view to load
    private void loadUI (String path, int type){
        Parent root = null;

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path + ".fxml"));
            root = loader.load();
            memberDashboard.setCenter(root);
            if (type == 0){
                if(path.equals("MembersMyAccount")) {
                    MembersMyAccountController controller = loader.getController();
                    controller.setActiveUser(activeUser);
                } else if(path.equals("ViewResource")) {
                    ViewResourceController controller = loader.getController();
                    controller.setActiveUser(activeUser);
                } else if(path.equals("SearchResource")) {
                    SearchResourceController controller = loader.getController();
                    controller.setActiveUser(activeUser);
                }
            }

        } catch (IOException ex){
            Logger.getLogger(MemberDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setActiveUser(User user) {
        this.activeUser = user;
        username.setText("Hello, " + user.getFirstName());
        loadUI("MembersMyAccount", 0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){

    }
}
