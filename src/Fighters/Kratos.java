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
    private Image[] listKratosKickL = new Image[14];
    private Image[] listKratosKickR = new Image[14];
    private Image[] listKratosKOL = new Image[16];
    private Image[] listKratosKOR = new Image[16];
    private Image[] listKratosWinL = new Image[32];
    private Image[] listKratosWinR = new Image[32];

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

        for(int i = 0; i < listKratosKickL.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosKickFramesL/Frame%s.png", Integer.toString(i));
            listKratosKickL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKickR.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosKickFramesR/Frame%s.png", Integer.toString(i));
            listKratosKickR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKOL.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosKOFramesL/Frame%s.png", Integer.toString(i));
            listKratosKOL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosKOR.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosKOFramesR/Frame%s.png", Integer.toString(i));
            listKratosKOR[i] = new Image(url);
        }

        for(int i = 0; i < listKratosWinL.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosWinFramesL/Frame%s.png", Integer.toString(i));
            listKratosWinL[i] = new Image(url);
        }

        for(int i = 0; i < listKratosWinR.length; i++ )
        {
            String url = String.format("/Assets/Kratos/KratosWinFramesR/Frame%s.png", Integer.toString(i));
            listKratosWinR[i] = new Image(url);
        }

        super.setImageFighters(imageKratosStanceL, imageKratosStanceR, imageKratosForwardL, imageKratosForwardR,
                imageKratosBackwardL, imageKratosBackwardR, imageKratosPunchL, imageKratosPunchR, imageKratosJumpL,
                imageKratosJumpR, listKratosJumpL, listKratosJumpR, listKratosPunchL, listKratosPunchR, listKratosKickL,
                listKratosKickR, listKratosKOL, listKratosKOR, listKratosWinL, listKratosWinR, 325,
                650, 900, 2180, 6990);
    }
}
