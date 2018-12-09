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
import javafx.scene.image.Image;
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
    public void initialize(URL location, ResourceBundle resource) {
    }

    @FXML
    public void searchResourceButton(ActionEvent event) {
        Tab selectedTab = resourcesTable.getSelectionModel().getSelectedItem();
        ListView activeView;

        ArrayList filterResources = Conn.searchResource(resourceSearchBar.getText());
        ArrayList allResources = Conn.searchResource("");
        ArrayList<String> filterData = new ArrayList<>();
        ArrayList<String> bookData = new ArrayList<>();
        ArrayList<String> dvdData = new ArrayList<>();
        ArrayList<String> laptopData = new ArrayList<>();
        ObservableList data;

        for (Object b : filterResources) {
            filterData.add(((Resources)b).getTitle());
        }

        for (Object b : allResources) {
            if(b instanceof Book) {
                bookData.add(((Book)b).getTitle());
            } else if (b instanceof  DVD) {
                dvdData.add(((DVD)b).getTitle());
            } else if (b instanceof Laptop) {
                laptopData.add(((Laptop)b).getTitle());
            }
        }

        if(resourceSearchBar.getText().equals("")) {
            if (selectedTab == bookTab) {
                activeView = bookResults;
                activeView.setItems(FXCollections.observableArrayList(bookData));

            } else if (selectedTab == dvdTab) {
                activeView = dvdResults;
                activeView.setItems(FXCollections.observableArrayList(dvdData));

            } else {
                activeView = laptopResults;
                activeView.setItems(FXCollections.observableArrayList(laptopData));

            }
        } else {
            data = FXCollections.observableArrayList(filterData);
            if (selectedTab == bookTab) {
                activeView = bookResults;
                activeView.setItems(data);

            } else if (selectedTab == dvdTab) {
                activeView = dvdResults;
                activeView.setItems(data);

            } else {
                activeView = laptopResults;
                activeView.setItems(data);
            }
        }

        activeView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ResourceInfo.fxml"));
                        Parent resourceRoot = null;
                        try {
                            resourceRoot = fxmlLoader.load();
                            ResourceInfoController controller = fxmlLoader.getController();
                            //controller.setResources(ov.getValue());
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
    public void searchResourcesQuery(ActionEvent event) {

    }
}
