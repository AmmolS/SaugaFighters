import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.security.KeyRep;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {

        Image background = new Image("/Assets/Background1.gif");
        ImageView imageView = new ImageView(background);
        imageView.setX(0);
        imageView.setY(0);
        Group root = new Group(imageView);
        Scene scene = new Scene(root, 1200, 603);
        stage.setTitle("Street Fighter");
        stage.setScene(scene);
        stage.show();

        Image image11 = new Image("/Assets/Kratos/KratosStance.gif");
        ImageView Kratos = new ImageView();
        Kratos.setFitHeight(300);
        Kratos.setFitWidth(290);
        Kratos.setImage(image11);
        Kratos.setPreserveRatio(true);
        Kratos.setX(300);
        Kratos.setY(300);
        root.getChildren().add(Kratos);

        scene.setOnKeyPressed(e->{
            //while (Kratos.getLayoutX() > 0)
            //{
                if (e.getCode() == KeyCode.RIGHT) {
                    //change the value of x and y appropriately
                    Kratos.setLayoutX(Kratos.getLayoutX() + 10);
                } else if (e.getCode() == KeyCode.LEFT) {
                    //change the value of x and y appropriately
                    Kratos.setLayoutX(Kratos.getLayoutX() - 10);
                }
            //}
            //check for other arrow keys
        });




        stage.getIcons().add(new Image("/Assets/Logo.png"));
    }



    public static void main(String args[]) {
        launch(args);
        System.out.println("");
    }

}