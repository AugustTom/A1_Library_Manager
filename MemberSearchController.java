package tawelib;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This MemberSearchController Class pairs with the "MemberSearch.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class MemberSearchController implements Initializable {

    @FXML
    private Pane memberSearchPage;

    @FXML
    private Button memberSearchButton;

    @FXML
    private TextField memberSearchQuery;

    @FXML
    ListView<String> memberDetailsResults = new ListView<String>();

    @FXML
    void selectMemberResult(ActionEvent event) {

        ObservableList<String> data = FXCollections.observableArrayList(
                "chocolate", "salmon", "gold", "coral", "darkorchid",
                "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
                "blueviolet", "brown");

        final Label label = new Label();
        memberDetailsResults.setItems(data);

        memberDetailsResults.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MembersMyAccount.fxml"));
                        Parent root1 = null;
                        try {
                            root1 = (Parent) fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.show();
                    }
                });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
