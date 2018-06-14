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

    Arena(Stage stage, Image aChoice)
    {
        this.arenaChoice = aChoice;
        ImageView background = new ImageView(this.arenaChoice);
        background.setX(0);
        background.setY(0);
        background.setFitWidth(1200);
        background.setFitHeight(603);

        Group arenaLayout = new Group();
        arenaLayout.getChildren().addAll(background);
        this.arena = new Scene(arenaLayout, 1200, 603);


    }

    public void setPlayer1(Fighter player1)
    {
        this.player1 = player1;
    }

    public void setPlayer2(Fighter player2)
    {
        this.player2 = player2;
    }

    public void setArenaChoice(Image aChoice)
    {
        this.arenaChoice = aChoice;
    }

    public Scene getArena()
    {
        return this.arena;
    }
}
