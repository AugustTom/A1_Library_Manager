package tawelib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* This is a subclass of the superclass Application
* <br>
* It is a main class that launches the avatar application
*
*
* @author Sebastian Gappa
* @version 1.0
* @since 05/12/2018
*/

public class AvatarMain extends Application {
    
    /**
    * This start method shows the stage and creates a new scene by loading the "Avatar.fxlml" file
    * @param stage
    */
    
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("tawelib/Avatar.fxml"))));
        stage.show();
    }
    
    /**
    * This is the main method that launches the application
    */

    public static void main(String[] args) {

        launch(args);
    }
}
