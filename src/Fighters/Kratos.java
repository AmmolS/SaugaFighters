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

    private Image[] listKratosPunchL = new Image[16];
    private Image[] listKratosPunchR = new Image[16];
    private Image[] listKratosJumpL = new Image[31];
    private Image[] listKratosJumpR = new Image[31];

    public Kratos()
    {

        for(int i = 0; i < listKratosPunchL.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosPunchFramesL/Frame%s.png", Integer.toString(i));
            listKratosPunchL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosPunchR.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosPunchFramesR/Frame%s.png", Integer.toString(i));
            listKratosPunchR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosJumpL.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosJumpFramesL/Frame%s.png", Integer.toString(i));
            listKratosJumpL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosJumpR.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosJumpFramesR/Frame%s.png", Integer.toString(i));
            listKratosJumpR[i] = new Image(url);
        }

        super.setImageFighters(imageKratosStanceL, imageKratosStanceR, imageKratosForwardL, imageKratosForwardR, imageKratosBackwardL, imageKratosBackwardR, imageKratosPunchL, imageKratosPunchR, imageKratosJumpL, imageKratosJumpR, listKratosJumpL, listKratosJumpR, listKratosPunchL, listKratosPunchR);
    }
}
