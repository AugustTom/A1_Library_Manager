package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
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
    void addNewLaptop(ActionEvent event) {
        ArrayList IDsOfCopies = new ArrayList<>();
        IDsOfCopies.add(1);
//        Book newbook = new Book (12, "helo", 1198, "img",IDsOfCopies, "her",
//                "gew", " 13445", "lahn") ;

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


        Laptop dvd = new Laptop (laptopID, laptopTitle, laptopYear, "1nsn", IDsOfCopies, laptopModel,
                laptopBrand, laptopOperatingSystem);
        Conn.writeObject(dvd);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
