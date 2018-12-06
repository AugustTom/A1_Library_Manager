package tawelib;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountController implements Initializable {

    @FXML
    private Pane createAccount;

    @FXML
    private TextField newUser_username;

    @FXML
    private TextField newUser_firstName;

    @FXML
    private TextField newUser_astName;

    @FXML
    private TextField newUser_ContactNumber;

    @FXML
    private TextField newUser_Address;

    @FXML
    private TextField newUser_employmentDate;

    @FXML
    private TextField newUser_staffNumber;

    @FXML
    private Button button_createAccount;

    @FXML
    private RadioButton avatar_sittingCat;

    @FXML
    private ToggleGroup selectAvatar;

    @FXML
    private RadioButton avatar_ghost;

    @FXML
    private RadioButton avatar_canvas;

    @FXML
    private RadioButton avatar_bird;

    @FXML
    private RadioButton avatar_fish;

    @FXML
    private RadioButton avatar_monster;

    @FXML
    void createAvatar(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Avatar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
