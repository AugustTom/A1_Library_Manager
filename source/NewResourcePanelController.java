package GUI;

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

public class NewResourcePanelController implements Initializable {

    @FXML
    private BorderPane newResourcePanel;

    @FXML
    private Button button_book;

    @FXML
    private Button button_DVD;

    @FXML
    private Button button_laptop;

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
            newResourcePanel.setCenter(root);
        } catch (IOException ex){
            Logger.getLogger(LibrarianDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
