package Fighters;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.RecursiveAction;

public class Fighter
{
    String player;
    String name;
    double health;
    double powerBar;
    double movementSpeed;
    double baseDamage;

    private Image imageFighterStanceL;
    private Image imageFighterStanceR;
    private Image imageFighterForwardL;
    private Image imageFighterForwardR;
    private Image imageFighterBackwardL;
    private Image imageFighterBackwardR;

    Fighter()
    {

    }
    Fighter(String inputName, double inputHealth, double inputPower, double inputMovement, double inputDamage)
    {

    }

    public void setImageFighters(Image stanceL, Image stanceR, Image forwardL, Image forwardR, Image backwardL, Image backwardR)
    {
        this.imageFighterStanceL = stanceL;
        this.imageFighterStanceR = stanceR;
        this.imageFighterForwardL = forwardL;
        this.imageFighterForwardR = forwardR;
        this.imageFighterBackwardL = backwardL;
        this.imageFighterBackwardR = backwardR;
    }

    public Image getImageFighterStanceL()
    {
        return this.imageFighterStanceL;
    }

    public Image getImageFighterStanceR()
    {
        return this.imageFighterStanceR;
    }

    public Image getImageFighterForwardL()
    {
        return this.imageFighterForwardL;
    }

    public Image getImageFighterForwardR()
    {
        return this.imageFighterForwardR;
    }

    public Image getImageFighterBackwardL()
    {
        return this.imageFighterBackwardL;
    }

    public Image getImageFighterBackwardR()
    {
        return this.imageFighterBackwardR;
    }

    public void Health(){
        Rectangle health_bar_left = new Rectangle(400, 200, javafx.scene.paint.Color.RED);
        Rectangle health_bar_right = new Rectangle(400, 200, javafx.scene.paint.Color.RED);

        health_bar_left.setX(0);
        health_bar_left.setY(0);

        health_bar_right.setX(0);
        health_bar_right.setY(1200);
    }
}
