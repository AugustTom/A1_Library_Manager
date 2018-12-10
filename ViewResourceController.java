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

    @FXML
    public void searchLoans(javafx.event.ActionEvent actionEvent) {
        Tab selectedTab = resourcesTable.getSelectionModel().getSelectedItem();
        ListView activeView;

        ArrayList actives = Conn.getActiveLoans(activeUser.getUserName());
        ArrayList<String> activeTitles = new ArrayList<String>();
        ArrayList requests = Conn.getLoanRequests(activeUser.getUserName());
        ArrayList<String> requestTitles = new ArrayList<String>();

        for (Object active: actives) {
            activeTitles.add(((Resources) active).getTitle());
            System.out.println(activeTitles.toString());
        }

        for (Object request: requests) {
            requestTitles.add(((Resources) request).getTitle());
            System.out.print((requestTitles.toString()));
        }

        if (selectedTab == borrowedTab) {
            activeView = borrowedList;
            activeView.setItems(FXCollections.observableArrayList(activeTitles));
        } else if (selectedTab == requestedTab) {
            activeView = requestedList;
            activeView.setItems(FXCollections.observableArrayList(requestTitles));
        }

    }

    public void setActiveUser(User user) {
        this.activeUser = user;
    }
}
