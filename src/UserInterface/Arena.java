package UserInterface;

import Fighters.Fighter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Arena
{
    Fighter player1;
    Fighter player2;
    Image arenaChoice;
    Scene arena;

    Arena(Stage stage, Fighter p1, Fighter p2, Image aChoice)
    {
        this.player1 = p1;
        this.player2 = p2;
        this.arenaChoice = aChoice;

        ImageView background = new ImageView(aChoice);
        background.setX(0);
        background.setY(0);
        background.setFitWidth(1200);
        background.setFitHeight(603);

        Group arenaLayout = new Group();
        arenaLayout.getChildren().addAll(background);
        this.arena = new Scene(arenaLayout, 1200, 603);


    }

    public Scene getArena()
    {
        return this.arena;
    }
}
