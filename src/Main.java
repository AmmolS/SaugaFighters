import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;


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


        scene.setOnKeyPressed(e->
                {
                if(e.getCode() == KeyCode.RIGHT)
                {
                    Kratos.setLayoutX(Kratos.getLayoutX() + 10);
                    if(Kratos.getLayoutX() > 600)
                    {
                        Kratos.setLayoutX(Kratos.getLayoutX() + 0);
                    }

                } if (e.getCode() == KeyCode.LEFT)
                {
                    //change the value of x and y appropriately
                        Kratos.setLayoutX(Kratos.getLayoutX() - 10);

                }
                if(e.getCode() == KeyCode.D)
                {
                    Kratos.setLayoutX(Kratos.getLayoutX() + 10);

                } if (e.getCode() == KeyCode.A)
                {
                //change the value of x and y appropriately
                    Kratos.setLayoutX(Kratos.getLayoutX() - 10);
                }

                if(e.getCode() == KeyCode.SPACE)
                {

                }

                }
        );

        stage.getIcons().add(new Image("/Assets/Logo.png"));
    }


    public void jump()
    {
        boolean jumping  = false;
        boolean falling = true;

    }

    public static void main(String args[]) {
        launch(args);
        System.out.println("");
    }

}