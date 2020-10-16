package fx;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainfx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ma premi�re fen�tre en Java");
        primaryStage.setScene(new Scene(root, 520, 380));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
