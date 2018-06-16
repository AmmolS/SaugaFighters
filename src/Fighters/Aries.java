package Fighters;

import javafx.scene.image.Image;

public class Aries extends Fighter
{
    private Image imageAriesStanceL = new Image("/Assets/Aries/AriesStance.gif");
    private Image imageAriesStanceR = new Image("/Assets/Aries/AriesStanceRight.gif");
    private Image imageAriesForwardL = new Image("/Assets/Aries/AriesForward.gif");
    private Image imageAriesForwardR = new Image("/Assets/Aries/AriesForwardRight.gif");
    private Image imageAriesBackwardL = new Image("/Assets/Aries/AriesBackward.gif");
    private Image imageAriesBackwardR = new Image("/Assets/Aries/AriesBackwardR.gif");
    private Image imageAriesPunchL = new Image("/Assets/Aries/AriesMPunch.gif");
    private Image imageAriesPunchR = new Image("/Assets/Aries/AriesMPunchR.gif");
    private Image imageAriesJumpL = new Image("/Assets/Aries/AriesJump.gif");
    private Image imageAriesJumpR = new Image("/Assets/Aries/AriesJumpR.gif");

    public Aries()
    {
        super.setImageFighters(imageAriesStanceL, imageAriesStanceR, imageAriesForwardL, imageAriesForwardR, imageAriesBackwardL, imageAriesBackwardR, imageAriesPunchL, imageAriesPunchR, imageAriesJumpL, imageAriesJumpR);
    }
}
