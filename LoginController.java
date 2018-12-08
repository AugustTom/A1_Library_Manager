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

import java.io.IOException;
import java.net.URL;
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
    private Button loginButton;


    /**
     * Logs user in when 'log in' button is pressed.
     * @param event
     * @throws IOException
     */
    @FXML
    void enterDashboard(Event event) throws IOException {
        final String username =  loginUsername.getText();

        Object activeUser = Conn.searchUsers(username).get(0);

        System.out.println(((User)activeUser).getUserName());
        if (activeUser != null) {
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
        } else
        {
            System.out.println("Invalid Login");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
