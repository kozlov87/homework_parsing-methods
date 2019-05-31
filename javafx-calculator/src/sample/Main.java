package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Simple calculator");
        primaryStage.setOnCloseRequest(x -> {
            Platform.exit();
        });
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static double calc(double n1, double n2, String op) {
        switch (op) {
            case "＋" :
                return n1 + n2;

            case "－" :
                return n1 - n2;

            case "×" :
                return n1 * n2;

            case "÷" :
                return n1 / n2;

            default :
        }
        return n2;
    }

    public static void main(String[] args) { launch(args); }
}
