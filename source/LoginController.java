package GUI;

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

public class LoginController implements Initializable {

    @FXML
    private Pane loginPage;

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;

    @FXML
    void librarianDashboard(MouseEvent event) throws IOException {
        Pane librarianDashboard = FXMLLoader.load(getClass().getResource("LibrarianDashboard.fxml"));
        loginPage.getChildren().setAll(librarianDashboard);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
