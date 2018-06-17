package UserInterface;

import Fighters.Fighter;
import javafx.animation.AnimationTimer;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;

public class Arena
{
    private Fighter player1, player2;
    private Image arenaChoice;
    private Scene arena;
    private ImageView background;
    private Group arenaLayout;
    private Boolean p1Jump = false;
    private Boolean p1Attack = false;
    private Boolean p2Jump = false;
    private Boolean p2Attack = false;


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
            if(player1.getHealth() > 0 && player2.getHealth() > 0)
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
                if(e.getCode() == KeyCode.W && !p1Jump)
                {
                    p1Jump = true;
                    p1.setY(303 - (player1.getImageFighterJumpL().getHeight() - player1.getImageFighterStanceL().getHeight()));
                    TranslateTransition jumpP1 = new TranslateTransition(Duration.millis(365), p1);
                    jumpP1.setByY(-300);
                    jumpP1.setAutoReverse(true);
                    jumpP1.setCycleCount(2);
                    jumpP1.play();

                    Transition jumpAnimationP1 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(365));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player1.getListFighterJumpL().length-1));
                            p1.setImage(player1.getListFighterJumpR()[index]);
                        }
                    };
                    jumpAnimationP1.play();

                    jumpP1.setOnFinished(event -> {
                        p1.setY(303);
                        p1.setImage(player1.getImageFighterStanceL());
                        p1Jump = false;
                    });


                    wPressed.set(true);
                }

                // Player 1 punches
                if(e.getCode() == KeyCode.S && !p1Attack)
                {
                    Transition punchAnimationP1 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(340));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player1.getListFighterPunchL().length-1));
                            p1.setImage(player1.getListFighterPunchL()[index]);
                        }
                    };
                    punchAnimationP1.play();
                    punchAnimationP1.setOnFinished(event -> p1.setImage(player1.getImageFighterStanceL()));
                    sPressed.set(true);
                    p1Attack = true;
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
                if(e.getCode() == KeyCode.UP && !p2Jump)
                {
                    p2Jump = true;
                    p2.setY(303 - (player2.getImageFighterJumpR().getHeight() - player2.getImageFighterStanceR().getHeight()));
                    TranslateTransition jumpP2 = new TranslateTransition(Duration.millis(325), p2);
                    jumpP2.setByY(-300);
                    jumpP2.setAutoReverse(true);
                    jumpP2.setCycleCount(2);
                    jumpP2.play();

                    Transition jumpAnimationP2 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(325));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player2.getListFighterJumpR().length-1));
                            p2.setImage(player2.getListFighterJumpR()[index]);
                        }
                    };
                    jumpAnimationP2.play();

                    jumpP2.setOnFinished(event -> {
                        p2.setY(303);
                        p2.setImage(player2.getImageFighterStanceR());
                        p2Jump = false;
                    });

                    upPressed.set(true);

                }

                // Player 2 punches
                if(e.getCode() == KeyCode.DOWN && !p2Attack)
                {
                    Transition punchAnimationP2 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(650));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player2.getListFighterPunchR().length-1));
                            p2.setImage(player2.getListFighterPunchR()[index]);
                        }
                    };
                    punchAnimationP2.play();
                    punchAnimationP2.setOnFinished(event -> p2.setImage(player2.getImageFighterStanceR()));
                    downPressed.set(true);
                    p2Attack = true;
                }

                // Player 2 kicks
                if(e.getCode() == KeyCode.CONTROL)
                {
                    rightControlPressed.set(true);
                }
            }
            else
                {
                    System.exit(0);
                }
        });

        arena.setOnKeyReleased(e ->
        {
            // Player 1
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
//                p1Jump = false;
            }

            if(e.getCode() == KeyCode.S)
            {
                sPressed.set(false);
                p1Attack = false;
            }

            if(e.getCode() == KeyCode.C)
            {
                cPressed.set(false);
            }

            // Player 2
            if(e.getCode() == KeyCode.LEFT)
            {
                leftPressed.set(false);
            }

            if(e.getCode() == KeyCode.RIGHT)
            {
                rightPressed.set(false);
            }

            if(e.getCode() == KeyCode.UP)
            {
                upPressed.set(false);
//                p2Jump = false;

            }

            if(e.getCode() == KeyCode.DOWN)
            {
                downPressed.set(false);
                p2Attack = false;
            }

            if(e.getCode() == KeyCode.CONTROL)
            {
                rightControlPressed.set(false);
            }


        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Player 1
                if (dPressed.get())
                {
                    p1.setX((p1.getX() + 5));
                }

                if (aPressed.get())
                {
                    p1.setX((p1.getX() - 5));
                }

                // Player 2
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

        // Player 1
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

        wPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(wPressed.get())
            {
                timer.start();
            }
//            else if(!wPressed.get())
//            {
//                p1.setImage(player1.getImageFighterStanceL());
//            }
        });

        sPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(sPressed.get())
            {
                if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
                            {
                                player2.takeDamage(20);
                                p2HealthBar.setWidth(player2.getHealth());
                                p2HealthBar.setX(p2HealthBar.getX() + 20);
                            }
                timer.start();
            }
            else if(!sPressed.get())
            {
                p1.setImage(player1.getImageFighterStanceL());
            }
        });

        cPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(cPressed.get())
            {
                timer.start();
            }
            else if(!cPressed.get())
            {
                p1.setImage(player1.getImageFighterStanceL());
            }
        });

        // Player 2
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

        upPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(upPressed.get())
            {
                timer.start();
            }
            else if(!upPressed.get())
            {
                p2.setImage(player2.getImageFighterStanceR());
            }
        });

        downPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(downPressed.get())
            {
                if (p2.getBoundsInParent().intersects(p1.getBoundsInParent()))
                            {
                                player1.takeDamage(20);
                                p1HealthBar.setWidth(player1.getHealth());
                            }
                timer.start();
            }
            else if(!downPressed.get())
            {
                p2.setImage(player2.getImageFighterStanceR());
            }
        });

        rightControlPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(rightControlPressed.get())
            {
                timer.start();
            }
            else if(!rightControlPressed.get())
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