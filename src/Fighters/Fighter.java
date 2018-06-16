package Fighters;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Fighter
{
    String player;
    String name;
    int health = 400;
    double powerBar;
    double movementSpeed;
    double baseDamage;

    private Image imageFighterStanceL;
    private Image imageFighterStanceR;
    private Image imageFighterForwardL;
    private Image imageFighterForwardR;
    private Image imageFighterBackwardL;
    private Image imageFighterBackwardR;
    private Image imageFighterPunchL;
    private Image imageFighterPunchR;

    Fighter()
    {

    }
    Fighter(String inputName, double inputHealth, double inputPower, double inputMovement, double inputDamage)
    {

    }

    public void setImageFighters(Image stanceL, Image stanceR, Image forwardL, Image forwardR, Image backwardL, Image backwardR, Image punchL, Image punchR)
    {
        this.imageFighterStanceL = stanceL;
        this.imageFighterStanceR = stanceR;
        this.imageFighterForwardL = forwardL;
        this.imageFighterForwardR = forwardR;
        this.imageFighterBackwardL = backwardL;
        this.imageFighterBackwardR = backwardR;
        this.imageFighterPunchL = punchL;
        this.imageFighterPunchR = punchR;
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

    public Image getImageFighterPunchL()
    {
        return this.imageFighterPunchL;
    }

    public Image getImageFighterPunchR()
    {
        return this.imageFighterPunchR;
    }

    public void takeDamage(int damage)
    {
        this.health -= damage;
    }

    public int getHealth()
    {
        return this.health;
    }

    public Rectangle getHealthBar()
    {
        Rectangle health_bar = new Rectangle(this.health, 20, Color.RED);
        return health_bar;
    }

}
