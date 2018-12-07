package tawelib;

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
 * @author Ronalyn Lilyanne
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
