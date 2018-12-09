package tawelib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

  /**
 * The main class for the program.
 * @author Ronalyn Lilyanne, Auguste Tomaseviciute
 * @version 1.0
 * @since 04/12/2018
 */

public class Main extends Application {
    public static Stage parentStage;

    /**
    *@throws Exception
    */
    @Override
    public void start(Stage stage) throws Exception{
        parentStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setTitle("Tawe-Lib");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
