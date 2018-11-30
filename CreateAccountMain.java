package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class CreateAccountMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        primaryStage.show();
    }
    

    public static void main(String[] args) {

        launch(args);
    }
}
