import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Street Fighters");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 1200, 603);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}