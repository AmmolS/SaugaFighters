package Fighters;

import javafx.scene.image.Image;

public class Aries extends Fighter
{

    public Aries()
    {
        Image imageAriesStanceL = new Image("/Assets/Aries/AriesStance.gif");
        Image imageAriesStanceR = new Image("/Assets/Aries/AriesStanceRight.gif");
        Image imageAriesForwardL = new Image("/Assets/Aries/AriesForward.gif");
        Image imageAriesForwardR = new Image("/Assets/Aries/AriesForwardRight.gif");
        Image imageAriesBackwardL = new Image("/Assets/Aries/AriesBackward.gif");
        Image imageAriesBackwardR = new Image("/Assets/Aries/AriesBackwardR.gif");
        Image imageAriesPunchL = new Image("/Assets/Aries/AriesMPunch.gif");
        Image imageAriesPunchR = new Image("/Assets/Aries/AriesMPunchR.gif");
        Image imageAriesJumpL = new Image("/Assets/Aries/AriesJump.gif");
        Image imageAriesJumpR = new Image("/Assets/Aries/AriesJumpR.gif");

        Image[] listAriesPunchL = new Image[8];
        Image[] listAriesPunchR = new Image[8];
        Image[] listAriesJumpL = new Image[34];
        Image[] listAriesJumpR = new Image[34];
        Image[] listAriesKickL = new Image[11];
        Image[] listAriesKickR = new Image[11];
        Image[] listAriesKOL = new Image[17];
        Image[] listAriesKOR = new Image[17];
        Image[] listAriesWinL = new Image[24];
        Image[] listAriesWinR = new Image[24];

        for(int i = 0; i < listAriesPunchL.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesPunchFramesL/Frame%s.png", Integer.toString(i));
            listAriesPunchL[i] = new Image(url);
        }

        for(int i = 0; i < listAriesPunchR.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesPunchFramesR/Frame%s.png", Integer.toString(i));
            listAriesPunchR[i] = new Image(url);
        }

        for(int i = 0; i < listAriesJumpL.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesJumpFramesL/Frame%s.png", Integer.toString(i));
            listAriesJumpL[i] = new Image(url);
        }

        for(int i = 0; i < listAriesJumpR.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesJumpFramesR/Frame%s.png", Integer.toString(i));
            listAriesJumpR[i] = new Image(url);
        }

        for(int i = 0; i < listAriesKickL.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesKickFramesL/Frame%s.png", Integer.toString(i));
            listAriesKickL[i] = new Image(url);
        }

        for(int i = 0; i < listAriesKickR.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesKickFramesR/Frame%s.png", Integer.toString(i));
            listAriesKickR[i] = new Image(url);
        }

        for(int i = 0; i < listAriesKOL.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesKOFramesL/Frame%s.png", Integer.toString(i));
            listAriesKOL[i] = new Image(url);
        }

        for(int i = 0; i < listAriesKOR.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesKOFramesR/Frame%s.png", Integer.toString(i));
            listAriesKOR[i] = new Image(url);
        }

        for(int i = 0; i < listAriesWinL.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesWinFramesL/Frame%s.png", Integer.toString(i));
            listAriesWinL[i] = new Image(url);
        }

        for(int i = 0; i < listAriesWinR.length; i++ )
        {
            String url = String.format("/Assets/Aries/AriesWinFramesR/Frame%s.png", Integer.toString(i));
            listAriesWinR[i] = new Image(url);
        }

        super.setImageFighters(imageAriesStanceL, imageAriesStanceR, imageAriesForwardL, imageAriesForwardR,
                imageAriesBackwardL, imageAriesBackwardR, imageAriesPunchL, imageAriesPunchR, imageAriesJumpL,
                imageAriesJumpR, listAriesJumpL, listAriesJumpR, listAriesPunchL, listAriesPunchR, listAriesKickL,
                listAriesKickR, listAriesKOL, listAriesKOR, listAriesWinL, listAriesWinR, 365,
                340, 460, 2250,3300);
    }
}
