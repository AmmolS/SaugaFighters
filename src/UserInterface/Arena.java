package UserInterface;

import Fighters.Fighter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Arena
{
    private Fighter player1, player2;
    private Image arenaChoice;
    private Scene arena;
    private ImageView background;
    private Group arenaLayout;

    public void play(Stage stage)
    {
        this.background = new ImageView(this.arenaChoice);
        this.background.setX(0);
        this.background.setY(0);
        this.background.setFitWidth(1200);
        this.background.setFitHeight(603);

        ImageView p1 = new ImageView(this.player1.getImageFighterStanceL());
        p1.setX(100);
        p1.setY(303);

        ImageView p2 = new ImageView(this.player2.getImageFighterStanceR());
        p2.setX(900);
        p2.setY(303);

        arenaLayout = new Group();
        arenaLayout.getChildren().addAll(this.background, p1, p2);
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
