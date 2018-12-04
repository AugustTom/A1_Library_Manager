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

public class LoginController implements Initializable {

    @FXML
    private Pane loginPage;

    @FXML
    private TextField loginUsername;

    @FXML
    private Button loginButton;

    @FXML
    void userDashboard(MouseEvent event) throws IOException {
            Pane userDashboard = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
            loginPage.getChildren().setAll(userDashboard);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
