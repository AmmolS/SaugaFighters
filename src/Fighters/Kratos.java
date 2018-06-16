package Fighters;

import javafx.scene.image.Image;

public class Kratos extends Fighter
{
    private Image imageKratosStanceL = new Image("/Assets/Kratos/KratosStance.gif");
    private Image imageKratosStanceR = new Image("/Assets/Kratos/KratosStanceRight.gif");
    private Image imageKratosForwardL = new Image("/Assets/Kratos/KratosForward.gif");
    private Image imageKratosForwardR = new Image("/Assets/Kratos/KratosForwardRight.gif");
    private Image imageKratosBackwardL = new Image("/Assets/Kratos/KratosBackward.gif");
    private Image imageKratosBackwardR = new Image("/Assets/Kratos/KratosBackwardRight.gif");
    private Image imageKratosPunchL = new Image("/Assets/Kratos/KratosHPunch.gif");
    private Image imageKratosPunchR = new Image("/Assets/Kratos/KratosHPunchR.gif");
    private Image imageKratosJumpL = new Image("/Assets/Kratos/KratosJump.gif");
    private Image imageKratosJumpR = new Image("/Assets/Kratos/KratosJumpR.gif");

    public Kratos()
    {
        super.setImageFighters(imageKratosStanceL, imageKratosStanceR, imageKratosForwardL, imageKratosForwardR, imageKratosBackwardL, imageKratosBackwardR, imageKratosPunchL, imageKratosPunchR, imageKratosJumpL, imageKratosJumpR);
    }
}
