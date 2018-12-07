package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This ViewResourcesController Class pairs with the "ViewResources.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */

public class ViewResourcesController implements Initializable {

    @FXML
    private Pane viewResources;

    @FXML
    private ScrollPane viewResourcesPage;

    @FXML
    private ListView<?> resourcesResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
