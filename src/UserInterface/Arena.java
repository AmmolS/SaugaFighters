package UserInterface;

import Fighters.Fighter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Arena
{
    private Fighter player1;
    private Fighter player2;
    private Image arenaChoice;
    private Scene arena;
    private ImageView background;
    private Group arenaLayout;

    Arena(Stage stage)
    {

        arenaLayout = new Group();
        arenaLayout.getChildren().addAll();
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
        this.background = new ImageView(this.arenaChoice);
        this.background.setX(0);
        this.background.setY(0);
        this.background.setFitWidth(1200);
        this.background.setFitHeight(603);
        arenaLayout.getChildren().add(this.background);
    }

    public Scene getArena()
    {
        return this.arena;
    }
}
