package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This SearchResourceController Class pairs with the "SearchResource.fxml" file
 *
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
    private ListView<?> bookResults;

    @FXML
    private Tab dvdTab;

    @FXML
    private ListView<?> dvdResults;

    @FXML
    private Tab laptopTab;

    @FXML
    private ListView<?> laptopResults;

    @FXML
    void searchResourceButton(ActionEvent event) {

    }

    @FXML
    void searchResourcesQuery(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
