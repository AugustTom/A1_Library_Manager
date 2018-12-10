package tawelib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
 /** The main method class paired with "AvatarController"
    * @author Seb Gappa
    * @version 1.0
    * @since 04/12/2018
    */
  

public class AvatarMain extends Application {
    /** This start method shows the stage and creates a new scene by loading the "Avatar.fxlml" file
    * @param stage - passes in the current stage
    */

    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Avatar.fxml"))));
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
