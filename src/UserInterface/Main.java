package UserInterface;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application
{

    public static void main(String args[])
    {
        System.out.println();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException
    {
        stage.setTitle("Sauga Fighterz");
        stage.getIcons().add(new Image("/Assets/Logo.png"));
        ArenaSelectScreen as = new ArenaSelectScreen(stage);
        CharacterSelectScreen cs = new CharacterSelectScreen(stage);
        Arena arena = new Arena();

        cs.setArenaSelect(as);
        cs.setArena(arena);
        as.setArenaSetup(arena);
        stage.setScene(Menu.ShowMenu(stage, cs));
        stage.show();


//        StackPane layout = new StackPane();
//        layout.getChildren().add(start);
//        layout.getChildren().add(imageView);

//        start.getStylesheets().add(getClass().getResource("UserInterface.Menu.css").toExternalForm());




//        Image KratosStance = new Image("/Assets/Fighters.Kratos/KratosStance.gif");
//        Image KratosForward = new Image("/Assets/Fighters.Kratos/KratosForward.gif");
//        Image KratosBackward = new Image("/Assets/Fighters.Kratos/KratosBackward.gif");
//        Image KratosKick = new Image("/Assets/Fighters.Kratos/KratosBackward.gif");
//
//        ImageView Fighters.Kratos = new ImageView();
//        Fighters.Kratos.setFitHeight(300);
//        Fighters.Kratos.setFitWidth(290);
//        Fighters.Kratos.setImage(KratosStance);
//        Fighters.Kratos.setPreserveRatio(true);
//        Fighters.Kratos.setX(300);
//        Fighters.Kratos.setY(300);
//        root.getChildren().add(Fighters.Kratos);
//
//
//        scene.setOnKeyPressed(e ->
//                {
//
//                        if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
//                            Fighters.Kratos.setImage(KratosForward);
//                            Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() + 30);
//                            if (Fighters.Kratos.getLayoutX() > 350) {
//                                Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() - 30);
//                            }
//
//                        } else if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) {
//                            Fighters.Kratos.setImage(KratosBackward);
//                            Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() - 10);
//                            if (Fighters.Kratos.getLayoutX() < -100) {
//                                Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() + 10);
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
}