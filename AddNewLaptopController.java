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
 * This AddNewLaptopController Class pairs with the "AddNewLaptop.fxml" file,
 * Handles all widgets within the fxml file and returns the appropriate values.
 * @author Auguste Tomaseviciute
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewLaptopController extends AddNewSuperclassController {

    @FXML
    private TextField newLaptopModel;

    @FXML
    private TextField newLaptopBrand;

    @FXML
    private TextField newLaptopOS;
    
    /**
     * This method adds a new laptop to the database, it reads the input text from the
     * fxml fields and translates them into usable data which constructs a laptop object,
     * that object is then written to the Conn class which writes it as a entry to the database.
     * <br>
     * It also has a constructor for a new laptop object.
     */
    @FXML
    public void addNewLaptop() {

        //Initially there is one copy
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);

        //Fetches the next free resourceID so that every resource has a unique identifier in the database.
        int laptopID = Conn.getNextAvailableID("laptop");

        //Retrieves input data from fxml fields and stores them in usable variables.
        String laptopTitle = titleField.getText();
        int laptopYear = Integer.parseInt(yearField.getText());
        String imageID = "hello";
        int laptopNumOfCopies = Integer.parseInt(numOfCopiesField.getText());
        int laptopDuration = Integer.parseInt(loanDurationField.getText());
        String laptopModel  = newLaptopModel.getText();
        String laptopBrand = newLaptopBrand.getText();
        String laptopOperatingSystem = newLaptopOS.getText();

        //Every book object can have more than one copy when inserted into the database.
        for (int idcount = 0; idcount < laptopNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }

        // Creates new laptop object.
        Laptop laptop = new Laptop (laptopID, laptopTitle, laptopYear, imageID, IDsOfCopies, laptopModel,
                laptopBrand, laptopOperatingSystem);

        //Write the book object to the databse.
        Conn.writeObject(laptop);

        //Reset the form.
        for(TextField field:textFieldArrayList){
            field.setText("");
        }

         //Alert Window, informs a successfull addition to the database.
        Alert alert = new Alert(Alert.AlertType.NONE, "Resource added", ButtonType.OK);
        alert.setWidth(100);
        alert.showAndWait();

    }

    //Passes all text fields into an array for easier manipulation.
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        textFieldArrayList.add(newLaptopModel);
        textFieldArrayList.add(newLaptopBrand);
        textFieldArrayList.add(newLaptopOS);
        init();

    }
}
