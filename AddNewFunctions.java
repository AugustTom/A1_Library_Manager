package tawelib;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Popup;

import java.io.File;
import java.io.IOException;

public class AddNewFunctions {

    public static Image chooseImage(File imageFile) {


        FileChooser fileChooser = new FileChooser();

        //Open directory from existing directory
        if (imageFile != null) {
            File existDirectory = imageFile.getParentFile();
            fileChooser.setInitialDirectory(existDirectory);
        }

        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show open file dialog
        imageFile = fileChooser.showOpenDialog(null);

        Image image = new Image(imageFile.toURI().toString());

        return image;
    }

    void PopWindow(String message) throws IOException {

    }


}
