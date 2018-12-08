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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This SearchResourceController Class pairs with the "SearchResource.fxml" file
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class SearchResourceController implements Initializable {

    @FXML
    private Pane searchResource;

    @FXML
    private TextField resourceSearchBar;

    @FXML
    private Button resourceSearchButton;

    @FXML
    private TabPane resourcesTable;

    @FXML
    private Tab bookTab;

    @FXML
    private ListView<String> bookResults;

    @FXML
    private Tab dvdTab;

    @FXML
    private ListView<String> dvdResults;

    @FXML
    private Tab laptopTab;

    @FXML
    private ListView<String> laptopResults;

    private User activeUser;

    @FXML
    void searchResourceButton(ActionEvent event) {
        Tab selectedTab = resourcesTable.getSelectionModel().getSelectedItem();
        ListView activeView;
        ArrayList<Resources> resources = Conn.searchResource(resourceSearchBar.getText());
        ArrayList<String> resourceTitles = new ArrayList<>();

        for (Resources b : resources) {
            resourceTitles.add(b.getTitle());
        }

        ObservableList data = FXCollections.observableArrayList(resourceTitles);

        if (selectedTab == bookTab) {
            activeView = bookResults;
        } else if (selectedTab == dvdTab) {
            activeView = dvdResults;
        } else {
            activeView = laptopResults;
        }


        activeView.setItems(data);


        activeView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResourceInfo.fxml"));
                        Parent resourceRoot = null;
                        try {
                            resourceRoot = (Parent) fxmlLoader.load();
                            //ViewResourceInfoController controller = fxmlLoader.getController();
                            //controller.getResource();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setScene(new Scene(resourceRoot));
                        stage.show();

                    }

                });

    }

    @FXML
    void searchResourcesQuery(ActionEvent event) {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }
}
