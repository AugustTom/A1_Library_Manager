package tawelib;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This LoginController Class works with the "LibrarianDashboard.fxml" and "MembersDashboard.fxml" files
 *
 *
 * @author Ronalyn Lilyanne and Auguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */

public class LoginController implements Initializable {

    @FXML
    private Pane loginPage;

    @FXML
    private TextField loginUsername;

    @FXML
    private Text welcomeMessage;

    @FXML
    private Button loginButton;


    /**
     * Logs user in when 'log in' button is pressed.
     * @param event
     * @throws IOException
     */
    @FXML
    void enterDashboard(Event event) throws IOException {
        final String username =  loginUsername.getText();

        ArrayList userReturn= Conn.searchUsers(username);

        if (!userReturn.isEmpty()) {
            Object activeUser = userReturn.get(0);
            System.out.println(activeUser);
            System.out.println("loading user " + ((User)activeUser).getUserName());

            if (Conn.isLibrarian(username)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LibrarianDashboard.fxml"));
                Pane librarianDashboard = loader.load();
                loginPage.getChildren().setAll(librarianDashboard);
                LibrarianDashboardController controller = loader.getController();
                controller.loadUser((Librarian) activeUser);

            } else {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("MembersDashboard.fxml"));
                Pane memberDashboard = loader.load();
                loginPage.getChildren().setAll(memberDashboard);
                MemberDashboardController controller = loader.getController();

                controller.setActiveUser((User) activeUser);

            }
        } else {
            System.out.println("Invalid Login");
            welcomeMessage.setText("Invalid Login");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
