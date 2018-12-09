package tawelib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;

public class ViewResourceController implements Initializable {

    @FXML
    private ListView<String> borrowedList;

    @FXML
    private ListView<String> requestedList;

    @FXML
    private TabPane resourcesTable;


    public void initialize(URL location, ResourceBundle resource) {

        Tab selectedTab = resourcesTable.getSelectionModel().getSelectedItem();
        ListView activeView;

        ArrayList resources = Conn.searchResource("");
        ArrayList<String> resourceTitles = new ArrayList<String>();

        for (Object b : resources) {

        }

        ObservableList data = FXCollections.observableArrayList(resourceTitles);

    }
}
