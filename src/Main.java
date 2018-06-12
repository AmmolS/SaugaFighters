import java.awt.*;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;


public class Main extends Application implements EventHandler<ActionEvent>
{

    ImageView title;
    Button start;
    Button quit;

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException
    {

        stage.setTitle("Street Fighters");
        stage.getIcons().add(new Image("/Assets/Logo.png"));

        Image background = new Image("/Assets/Menu/Start_Menu.gif");
        ImageView imageView = new ImageView(background);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(603);
        imageView.setFitWidth(1200);

        Image imageStart = new Image(getClass().getResourceAsStream("/Assets/Menu/start.png"));
        Image imageQuit = new Image(getClass().getResourceAsStream("/Assets/Menu/quit.png"));
        Image imageTitle = new Image(getClass().getResourceAsStream("/Assets/Menu/title.png"));
//        start = new Button("", new ImageView(imageStart));

        title = new ImageView(imageTitle);
        title.setX(100);
        title.setY(50);

        start = new Button();
        start.setGraphic(new ImageView(imageStart));
        start.setStyle("-fx-background-color: transparent; ");
        start.setOnAction(this);
        start.setLayoutX(525);
        start.setLayoutY(300);

        quit = new Button();
        quit.setGraphic(new ImageView(imageQuit));
        quit.setStyle("-fx-background-color: transparent; ");
        quit.setOnAction(this);
        quit.setLayoutX(465);
        quit.setLayoutY(375);

//        StackPane layout = new StackPane();
//        layout.getChildren().add(start);
//        layout.getChildren().add(imageView);

        Group root = new Group(imageView);
        root.getChildren().add(title);
        root.getChildren().add(start);
        root.getChildren().add(quit);

        Scene scene = new Scene(root, 1200, 603);

//        start.getStylesheets().add(getClass().getResource("Menu.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

//        Image KratosStance = new Image("/Assets/Kratos/KratosStance.gif");
//        Image KratosForward = new Image("/Assets/Kratos/KratosForward.gif");
//        Image KratosBackward = new Image("/Assets/Kratos/KratosBackward.gif");
//        Image KratosKick = new Image("/Assets/Kratos/KratosBackward.gif");
//
//        ImageView Kratos = new ImageView();
//        Kratos.setFitHeight(300);
//        Kratos.setFitWidth(290);
//        Kratos.setImage(KratosStance);
//        Kratos.setPreserveRatio(true);
//        Kratos.setX(300);
//        Kratos.setY(300);
//        root.getChildren().add(Kratos);
//
//
//        scene.setOnKeyPressed(e ->
//                {
//
//                        if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
//                            Kratos.setImage(KratosForward);
//                            Kratos.setLayoutX(Kratos.getLayoutX() + 30);
//                            if (Kratos.getLayoutX() > 350) {
//                                Kratos.setLayoutX(Kratos.getLayoutX() - 30);
//                            }
//
//                        } else if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) {
//                            Kratos.setImage(KratosBackward);
//                            Kratos.setLayoutX(Kratos.getLayoutX() - 10);
//                            if (Kratos.getLayoutX() < -100) {
//                                Kratos.setLayoutX(Kratos.getLayoutX() + 10);
//                            }
//                        }
//
//                        if (e.getCode() == KeyCode.ENTER)
//                        {
//
//                        }
//
//
//                }
//
//        );
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource() == start)
        {
            System.out.println("k");
        }
    }



}