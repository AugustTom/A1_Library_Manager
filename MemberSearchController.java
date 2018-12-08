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
import java.util.ArrayList;
import java.util.Objects;
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

        ArrayList searchMemberResult = Conn.searchUsers(memberSearchQuery.getText());


        ObservableList<String> data = FXCollections.observableArrayList();

        //Get names of users
        for(Object obj: searchMemberResult)
        {
            data.add(((User)obj).userName);
        }


        final Label label = new Label();
        memberDetailsResults.setItems(data);

        memberDetailsResults.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {

                        FXMLLoader loader = new FXMLLoader( getClass().getResource("ViewMemberInfo.fxml"));
                        Parent rootMemberInfo = null;
                        try {
                            Librarian selectedUser = (Librarian) Objects.requireNonNull(Conn.searchUsers(ov.getValue())).get(0);
                            if (selectedUser != null) {

                                System.out.println("Loaded");
                                rootMemberInfo = loader.load();
                                ViewMemberInfoController controller = loader.getController();
                                controller.setActiveUser(selectedUser);
                                Stage stage = new Stage();
                                stage.setScene(new Scene(rootMemberInfo));
                                stage.show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
