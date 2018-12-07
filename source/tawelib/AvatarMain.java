package tawelib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AvatarMain extends Application {

    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Avatar.fxml"))));
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}