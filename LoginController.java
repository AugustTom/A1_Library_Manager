package tawelib;

import javafx.event.ActionEvent;
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
    void librarianDashboard(MouseEvent event) throws IOException {
        final String username =  loginUsername.getText();

        if( username.equals("lib")) {
            Pane librarianDashboard = FXMLLoader.load(getClass().getResource("LibrarianDashboard.fxml"));
            loginPage.getChildren().setAll(librarianDashboard);
        } else {
            Pane memberDashboard = FXMLLoader.load(getClass().getResource("MembersDashboard.fxml"));
            loginPage.getChildren().setAll(memberDashboard);
        }

    }


    /**
     * Logs user in after enter key is pressed.
     * @param enterkey
     * @throws IOException
     */
    @FXML
    void onEnter(ActionEvent enterkey) throws IOException {
        final String username =  loginUsername.getText();

        if( username.equals("lib")) {
            Pane librarianDashboard = FXMLLoader.load(getClass().getResource("LibrarianDashboard.fxml"));
            loginPage.getChildren().setAll(librarianDashboard);
        } else {
            Pane memberDashboard = FXMLLoader.load(getClass().getResource("MembersDashboard.fxml"));
            loginPage.getChildren().setAll(memberDashboard);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
