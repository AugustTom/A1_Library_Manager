package tawelib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;
import javafx.scene.control.*;

/**
 * This class allows us to view resources
 *
 * @author Sebastain Gappa
 * @version 1.0
 * @since 10/12/2018
 */

public class ViewResourceController implements Initializable {

    private User activeUser;

    @FXML
    private Button refresh;

    @FXML
    private Tab borrowedTab;

    @FXML
    private Tab requestedTab;

    @FXML
    private ListView<String> borrowedList;

    @FXML
    private ListView<String> requestedList;

    @FXML
    private TabPane resourcesTable;

    @FXML
    public void initialize(URL location, ResourceBundle resource) {
    }
    
    /**
     * This method searches everything you've borrowed and everything you've requested
     */

    @FXML
    public void searchLoans(javafx.event.ActionEvent actionEvent) {
        Tab selectedTab = resourcesTable.getSelectionModel().getSelectedItem();
        ListView activeView;

        ArrayList actives = Conn.getActiveLoans(activeUser.getUserName());
        ArrayList<String> titles = new ArrayList<String>();

        for (Object active: actives) {
            titles.add(((Resources) active).getTitle());
        }

        ObservableList data = FXCollections.observableArrayList(titles);

        if (selectedTab == borrowedTab) {
            activeView = borrowedList;
            activeView.setItems(data);
        } else if (selectedTab == requestedTab) {
            activeView = requestedList;
            activeView.setItems(data);
        }

    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }
}
