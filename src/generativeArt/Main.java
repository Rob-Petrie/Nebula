package generativeArt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        primaryStage.setTitle("Generative Art");
        Scene scene = new Scene(root, 1500, 900);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.prefWidthProperty().bind(scene.widthProperty());
        root.prefHeightProperty().bind(scene.heightProperty());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
