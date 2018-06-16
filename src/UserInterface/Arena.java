package UserInterface;

import Fighters.Fighter;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Arena
{
    private Fighter player1, player2;
    private Image arenaChoice;
    private Scene arena;
    private ImageView background;
    private Group arenaLayout;

    private Rectangle p1HealthBar;
    private Rectangle p2HealthBar;

    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty cPressed = new SimpleBooleanProperty();

    private BooleanProperty rightPressed = new SimpleBooleanProperty();
    private BooleanProperty leftPressed = new SimpleBooleanProperty();
    private BooleanProperty upPressed = new SimpleBooleanProperty();
    private BooleanProperty downPressed = new SimpleBooleanProperty();
    private BooleanProperty rightControlPressed = new SimpleBooleanProperty();

    private BooleanBinding dAndRightPressed = dPressed.and(rightPressed);
    private BooleanBinding dAndLeftPressed = dPressed.and(leftPressed);

    private BooleanBinding aAndRightPressed = aPressed.and(rightPressed);
    private BooleanBinding aAndLeftPressed = aPressed.and(leftPressed);

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

        p1HealthBar = player1.getHealthBar();
        p1HealthBar.setX(0);
        p1HealthBar.setY(0);

        p2HealthBar = player2.getHealthBar();
        p2HealthBar.setX(800);
        p2HealthBar.setY(0);

        Circle center = new Circle(20, Color.BLUE);

        center.setCenterX(600);
        center.setCenterY(0);

        arenaLayout = new Group();
        arenaLayout.getChildren().addAll(this.background, p1, p2, p1HealthBar, p2HealthBar);
        this.arena = new Scene(arenaLayout, 1200, 603);

        arena.setOnKeyPressed(e ->
        {
            // Player 1
            // Player 1 moves right
            if(e.getCode() == KeyCode.D)
            {
                p1.setImage(player1.getImageFighterForwardL());
                dPressed.set(true);
            }

            // Player 1 moves left
            if(e.getCode() == KeyCode.A)
            {
                p1.setImage(player1.getImageFighterBackwardL());
                aPressed.set(true);
            }

            // Player 1 jumps
            if(e.getCode() == KeyCode.W)
            {
//                p1.setImage();
                wPressed.set(true);
            }

            // Player 1 punches
            if(e.getCode() == KeyCode.S)
            {
                p1.setImage(player1.getImageFighterPunchL());
                sPressed.set(true);
            }

            // Player 1 kicks
            if(e.getCode() == KeyCode.C)
            {
//                p1.setImage(player1.getImageFighterPunchL());
                cPressed.set(true);
            }

            // Player 2
            // Player 2 moves left
            if(e.getCode() == KeyCode.LEFT)
            {
                p2.setImage(player2.getImageFighterForwardR());
                leftPressed.set(true);
            }

            // Player 2 moves right
            if(e.getCode() == KeyCode.RIGHT)
            {
                p2.setImage(player2.getImageFighterBackwardR());
                rightPressed.set(true);
            }

            // Player 2 jumps
            if(e.getCode() == KeyCode.UP)
            {
                upPressed.set(true);
            }

            // Player 2 punches
            if(e.getCode() == KeyCode.DOWN)
            {
                p2.setImage(player2.getImageFighterPunchR());
                downPressed.set(true);
            }

            // Player 2 kicks
            if(e.getCode() == KeyCode.CONTROL)
            {
                rightControlPressed.set(true);
            }




        });

        arena.setOnKeyReleased(e ->
        {
            if(e.getCode() == KeyCode.D)
            {
                dPressed.set(false);
            }

            if(e.getCode() == KeyCode.A)
            {
                aPressed.set(false);
            }

            if(e.getCode() == KeyCode.W)
            {
                wPressed.set(false);
            }

            if(e.getCode() == KeyCode.S)
            {

            }

            if(e.getCode() == KeyCode.LEFT)
            {
                leftPressed.set(false);
            }

            if(e.getCode() == KeyCode.RIGHT)
            {
                rightPressed.set(false);
            }

        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dPressed.get())
                {
                    p1.setX((p1.getX() + 5));
                }

                if (aPressed.get())
                {
                    p1.setX((p1.getX() - 5));
                }

                if (leftPressed.get())
                {
                    p2.setX((p2.getX() - 5));
                }

                if (rightPressed.get())
                {
                    p2.setX((p2.getX() + 5));
                }
            }
        };


        dPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(dPressed.get())
            {
                timer.start();
            }
            else if(!dPressed.get())
            {
                p1.setImage(player1.getImageFighterStanceL());
            }

        });

        aPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(aPressed.get())
            {
                timer.start();
            }
            else if(!aPressed.get())
            {
                p1.setImage(player1.getImageFighterStanceL());
            }

        });

        leftPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(leftPressed.get())
            {
                timer.start();
            }
            else if(!leftPressed.get())
            {
                p2.setImage(player2.getImageFighterStanceR());
            }
        });

        rightPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(rightPressed.get())
            {
                timer.start();
            }
            else if(!rightPressed.get())
            {
                p2.setImage(player2.getImageFighterStanceR());
            }
        });


//        dAndLeftPressed.addListener((obs, wasPressed, nowPressed) ->
//        {
//            if(nowPressed)
//            {
//                timer.start();
//            }
//        });


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




//              {
//                    if(player1.getHealth() > 0 && player2.getHealth() > 0)
//                    {
//                        // Player 1
//                        if (e.getCode() == KeyCode.D) {
//                            p1.setImage(player1.getImageFighterForwardL());
//                            p1.setLayoutX(p1.getLayoutX() + 30);
//                            if (p1.getLayoutX() > 1000) {
//                                p1.setLayoutX(p1.getLayoutX() - 30);
//                            }
//                        }
//                        if (e.getCode() == KeyCode.A) {
//                            p1.setImage(player1.getImageFighterBackwardL());
//                            p1.setLayoutX(p1.getLayoutX() - 10);
//                            if (p1.getLayoutX() < -100) {
//                                p1.setLayoutX(p1.getLayoutX() + 10);
//                            }
//                        }
//                        if (e.getCode() == KeyCode.F )
//                        {
//                            p1.setImage(player1.getImageFighterPunchL());
//                            if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
//                            {
//                                player2.takeDamage(20);
//                                System.out.println(player2.getHealth());
//                            }
//                        }
//
//                        if (e.getCode() == KeyCode.F && this.pressAttack)
//                        {
//                            p1.setImage(new Image("/Assets/Aries/AriesMPunch.gif"));
//                            this.pressAttack = true;
//                            if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
//                            {
//                                player2.takeDamage(20);
//                            }
//                        }
//                        else if(e.getCode() == KeyCode.S)
//                        {
//                            p1.setImage(player1.getImageFighterStanceL());
//                        }
//
//
//                        // Player 2
//                        if (e.getCode() == KeyCode.LEFT)
//                        {
//                            p2.setImage(player2.getImageFighterForwardR());
//                            p2.setLayoutX(p2.getLayoutX() - 30);
//                            if (p2.getLayoutX() < -1000) {
//                                p2.setLayoutX(p2.getLayoutX() + 30);
//                            }
//                        }
//
//                        if (e.getCode() == KeyCode.RIGHT)
//                        {
//                            p2.setImage(player2.getImageFighterBackwardR());
//                            p2.setLayoutX(p2.getLayoutX() + 10);
//                            if (p2.getLayoutX() > 100) {
//                                p2.setLayoutX(p2.getLayoutX() - 10);
//                            }
//                        }
//
//                        if (e.getCode() == KeyCode.DOWN)
//                        {
//                            p2.setImage(player2.getImageFighterPunchR());
//                        }
//                    }
//                    else
//                        {
//                            System.exit(0);
//                        }
//                }