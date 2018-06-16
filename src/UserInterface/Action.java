package UserInterface;

import Fighters.Fighter;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Action
{
    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();

    private BooleanProperty rightPressed = new SimpleBooleanProperty();
    private BooleanProperty leftPressed = new SimpleBooleanProperty();

    private BooleanBinding dAndRightPressed = dPressed.and(rightPressed);
    private BooleanBinding dAndLeftPressed = dPressed.and(leftPressed);

    private BooleanBinding aAndRightPressed = aPressed.and(rightPressed);
    private BooleanBinding aAndLeftPressed = aPressed.and(leftPressed);

    private Boolean pressAttack = false;

    public void input(KeyEvent e, ImageView p1, ImageView p2, Fighter player1, Fighter player2)
    {
        // Player 1
        if (e.getCode() == KeyCode.D) {
            dPressed.set(true);
            p1.setImage(player1.getImageFighterForwardL());
            p1.setLayoutX(p1.getLayoutX() + 30);
            if (p1.getLayoutX() > 1000) {
                p1.setLayoutX(p1.getLayoutX() - 30);
            }
        }
        if (e.getCode() == KeyCode.A) {
            p1.setImage(player1.getImageFighterBackwardL());
            p1.setLayoutX(p1.getLayoutX() - 10);
            if (p1.getLayoutX() < -100) {
                p1.setLayoutX(p1.getLayoutX() + 10);
            }
        }
        if (e.getCode() == KeyCode.F && !this.pressAttack)
        {
            p1.setImage(new Image("/Assets/Aries/AriesMPunch.gif"));
            this.pressAttack = true;
            if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
            {
                player2.takeDamage(20);
            }
        }
        else if(e.getCode() == KeyCode.S)
        {
            p1.setImage(player1.getImageFighterStanceL());
        }

        if (e.getCode() == KeyCode.F && !this.pressAttack)
        {
            p1.setImage(new Image("/Assets/Aries/AriesMPunch.gif"));
            this.pressAttack = true;
            if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
            {
                player2.takeDamage(20);
            }
        }
        else if(e.getCode() == KeyCode.S)
        {
            p1.setImage(player1.getImageFighterStanceL());
        }


        // Player 2
        if (e.getCode() == KeyCode.LEFT)
        {
            leftPressed.set(true);
            p2.setImage(player2.getImageFighterForwardR());
            p2.setLayoutX(p2.getLayoutX() - 30);
            if (p2.getLayoutX() < -1000) {
                p2.setLayoutX(p2.getLayoutX() + 30);
            }
        }

        if (e.getCode() == KeyCode.RIGHT)
        {
            p2.setImage(player2.getImageFighterBackwardR());
            p2.setLayoutX(p2.getLayoutX() + 10);
            if (p2.getLayoutX() > 100) {
                p2.setLayoutX(p2.getLayoutX() - 10);
            }
        }

        if (e.getCode() == KeyCode.DOWN)
        {
            p2.setImage(player2.getImageFighterPunchR());
        }

        dAndLeftPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if (nowPressed)
            {
                p1.setImage(player1.getImageFighterForwardL());
                p1.setLayoutX(p1.getLayoutX() + 30);
                if (p1.getLayoutX() > 1000) {
                    p1.setLayoutX(p1.getLayoutX() - 30);
                }

                p2.setImage(player2.getImageFighterForwardR());
                p2.setLayoutX(p2.getLayoutX() - 30);
                if (p2.getLayoutX() < -1000) {
                    p2.setLayoutX(p2.getLayoutX() + 30);
                }
            }
        });

    }
}
