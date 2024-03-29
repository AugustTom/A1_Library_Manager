package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This NewResourcePanelController Class pairs with the "NewResourcePanel.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class NewResourcePanelController implements Initializable {

    @FXML
    private BorderPane addNewResourcePanel;

    @FXML
    private Button newBookButton;

    @FXML
    private Button newDVDButton;

    @FXML
    private Button newLaptopButton;


    @FXML
    void addNewBook(MouseEvent event) {
        loadUI("AddNewBook");
    }

    @FXML
    void addNewDVD(MouseEvent event) {
        loadUI("AddNewDVD");
    }

    @FXML
    void addNewLaptop(MouseEvent event) {
        loadUI("AddNewLaptop");
    }

    private void loadUI (String path){
        Parent root = null;
        try{
            root = FXMLLoader.load(getClass().getResource(path + ".fxml"));
            addNewResourcePanel.setCenter(root);
        } catch (IOException ex){
            Logger.getLogger(LibrarianDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
