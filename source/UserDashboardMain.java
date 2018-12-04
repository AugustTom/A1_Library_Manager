package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserDashboardMain extends Application {
    public static Stage parentStage;

    @Override
    public void start(Stage stage) throws Exception{
        parentStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
        stage.setTitle("Tawe-Lib");
        stage.setScene(new Scene(root));
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
