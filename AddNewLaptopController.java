package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
 * @author Ronalyn Nanong
 * @version 1.0
 * @since 04/12/2018
 */

public class AddNewLaptopController implements Initializable {

    File imageFile; //Stores path to resource image.

    @FXML
    private Pane addNewLaptopPage;

    @FXML
    private TextField newLaptopID;

    @FXML
    private TextField newLaptopTitle;

    @FXML
    private TextField newLaptopYear;

    @FXML
    private TextField newLaptopCopies;

    @FXML
    private TextField newLaptopLoanDuration;

    @FXML
    private Button browseImageButton;

    @FXML
    private TextField newLaptopModel;

    @FXML
    private Button addNewLaptopButton;

    @FXML
    private ImageView newLaptopImage;

    @FXML
    private TextField newLaptopBrand;

    @FXML
    private TextField newLaptopOS;

    @FXML
    void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));

        //Open directory from existing directory
        if(imageFile != null){
            File existDirectory = imageFile.getParentFile();
            fileChooser.setInitialDirectory(existDirectory);
        }

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        imageFile = fileChooser.showOpenDialog(null);

        Image image = new Image(imageFile.toURI().toString());

        newLaptopImage.setImage(image);

    }

    @FXML
    void addNewLaptop(ActionEvent event) {
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);


        System.out.println("adding new dvd");
        int laptopID = Integer.parseInt(newLaptopID.getText());
        String laptopTitle = newLaptopTitle.getText();
        int laptopYear = Integer.parseInt(newLaptopYear.getText());
        int laptopNumOfCopies = Integer.parseInt(newLaptopCopies.getText());
        int laptopDuration = Integer.parseInt(newLaptopLoanDuration.getText());

        String laptopModel  = newLaptopModel.getText();
        String laptopBrand = newLaptopBrand.getText();
        String laptopOperatingSystem = newLaptopOS.getText();

        for (int idcount = 0; idcount < laptopNumOfCopies; idcount++) {
            IDsOfCopies.add(idcount);
        }


        Laptop laptop = new Laptop (laptopID, laptopTitle, laptopYear, "1nsn", IDsOfCopies, laptopModel,
                laptopBrand, laptopOperatingSystem);
        Conn.writeObject(laptop);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
