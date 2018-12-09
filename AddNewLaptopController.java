package tawelib;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This AddNewLaptopController Class pairs with the "AddNewLaptop.fxml" file
 *
 *
 * @author Auguste Tomaseviciute
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewLaptopController extends AddNewSuperclassController {

    File imageFile;


    @FXML
    private TextField newLaptopModel;


    @FXML
    private TextField newLaptopBrand;

    @FXML
    private TextField newLaptopOS;
    
    /**
     * This method adds a new laptop to the database
     * <br>
     * It also has a constructor
     * @param event
     */

    @FXML
    void addNewLaptop(ActionEvent event) {
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);


        System.out.println("adding new dvd");
        int laptopID = Conn.getNextAvailableID("laptop");
        String laptopTitle = titleField.getText();
        int laptopYear = Integer.parseInt(yearField.getText());
        String imageID = "hello";
        int laptopNumOfCopies = Integer.parseInt(numOfCopiesField.getText());
        int laptopDuration = Integer.parseInt(loanDurationField.getText());

        String laptopModel  = newLaptopModel.getText();
        String laptopBrand = newLaptopBrand.getText();
        String laptopOperatingSystem = newLaptopOS.getText();

        for (int idcount = 0; idcount < laptopNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }


        Laptop laptop = new Laptop (laptopID, laptopTitle, laptopYear, imageID, IDsOfCopies, laptopModel,
                laptopBrand, laptopOperatingSystem);
        Conn.writeObject(laptop);
        for(TextField field:textFieldArrayList){
            field.setText("");
        }
         //Alert Window
        Alert alert = new Alert(Alert.AlertType.NONE, "Resource added", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();

    }
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textFieldArrayList.add(newLaptopModel);
        textFieldArrayList.add(newLaptopBrand);
        textFieldArrayList.add(newLaptopOS);
        init();
    }
}
