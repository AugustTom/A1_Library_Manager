package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class AddNewDVDMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("AddNewDVD.fxml"));
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
