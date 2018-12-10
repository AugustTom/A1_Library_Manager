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
import java.util.ResourceBundle;

/**
 * This SearchResourceController Class pairs with the "SearchResource.fxml" file
 *
 * @author Sebastian Gappa
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
    
    /**
     * Button for searching resources
     */

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
            filterData.add(Integer.toString(((Resources)b).getID()));
            filterData.add(Integer.toString(((Resources)b).getYear()));
        }

        for (Object b : allResources) {
            if(b instanceof Book) {
                bookData.add("ID: " + ((Book)b).getID() + " " + "'" + ((Book)b).getTitle() + "'"  + " " +((Book)b).getYear());
            } else if (b instanceof  DVD) {
                dvdData.add("ID: " + ((DVD)b).getID() + " " + "'" + ((DVD)b).getTitle() + "'"  + " " +((DVD)b).getYear());
            } else if (b instanceof Laptop) {
                laptopData.add("ID: " + ((Laptop)b).getID() + " " + "'" + ((Laptop)b).getTitle() + "'"  + " " +((Laptop)b).getYear());
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


            } else if (selectedTab == dvdTab) {
                activeView = dvdResults;


            } else {
                activeView = laptopResults;

            }
            activeView.setItems(data);
        }

        activeView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                        if(Conn.isLibrarian(activeUser.getUserName())) {
                            FXMLLoader librarianFXMLLoader = new FXMLLoader(getClass().getResource("LibrarianResourceInfo.fxml"));
                            Parent resourceRoot = null;
                            try {
                                resourceRoot = librarianFXMLLoader.load();
                                LibrarianResourceInfoController controller = librarianFXMLLoader.getController();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Stage stage = new Stage();
                            stage.setScene(new Scene(resourceRoot));
                            stage.show();
                        } else {
                            FXMLLoader userFXMLLoader = new FXMLLoader(getClass().getResource("UserResourceInfo.fxml"));
                            Parent resourceRoot = null;
                            try {
                                resourceRoot = userFXMLLoader.load();
                                UserResourceInfoController controller = userFXMLLoader.getController();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Stage stage = new Stage();
                            stage.setScene(new Scene(resourceRoot));
                            stage.show();
                        }
                    }
                });
    }

    public void setActiveUser(User user) {

        this.activeUser = user;
    }
}
