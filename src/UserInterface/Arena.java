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

    private Boolean p1JumpAction = false;
    private Boolean p1PunchAction = false;
    private Boolean p1KickAction = false;
    private Boolean p2JumpAction = false;
    private Boolean p2PunchAction = false;
    private Boolean p2KickAction = false;

    private Boolean gameOver = false;

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
    private BooleanProperty rightEnterPressed = new SimpleBooleanProperty();

    public void play(Stage stage)
    {
        ImageView background = new ImageView(this.arenaChoice);
        background.setX(0);
        background.setY(0);
        background.setFitWidth(1200);
        background.setFitHeight(603);

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

        ImageView player1Text = new ImageView(new Image("/Assets/player1.png"));
        player1Text.setFitWidth(250);
        player1Text.setFitHeight(100);
        player1Text.setX(0);
        player1Text.setY(0);

        ImageView player2Text = new ImageView(new Image("/Assets/player2.png"));
        player2Text.setFitWidth(250);
        player2Text.setFitHeight(100);
        player2Text.setX(950);
        player2Text.setY(0);

        Circle center = new Circle(20, Color.BLUE);

        center.setCenterX(600);
        center.setCenterY(0);

        Group arenaLayout = new Group();
        arenaLayout.getChildren().addAll(background, p1, p2, p1HealthBar, p2HealthBar, player1Text, player2Text);
        this.arena = new Scene(arenaLayout, 1200, 603);

        arena.setOnKeyPressed(e ->
        {
            if(player1.getHealth() > 0 && player2.getHealth() > 0)
            {
                // Player 1
                // Player 1 moves right
                if(e.getCode() == KeyCode.D && !p1PunchAction && !p1KickAction)
                {
                    p1.setImage(player1.getImageFighterForwardL());
                    dPressed.set(true);
                }

                // Player 1 moves left
                if(e.getCode() == KeyCode.A && !p1PunchAction && !p1KickAction)
                {
                    p1.setImage(player1.getImageFighterBackwardL());
                    aPressed.set(true);
                }

                // Player 1 jumps
                if(e.getCode() == KeyCode.W && !p1JumpAction && !p1PunchAction && !p1KickAction && !wPressed.get())
                {
                    p1JumpAction = true;
                    p1.setY(303 - (player1.getImageFighterJumpL().getHeight() - player1.getImageFighterStanceL().getHeight()));
                    TranslateTransition jumpP1 = new TranslateTransition(Duration.millis(player1.getFighterJumpDuration()), p1);
                    jumpP1.setByY(-300);
                    jumpP1.setAutoReverse(true);
                    jumpP1.setCycleCount(2);
                    jumpP1.play();

                    Transition jumpAnimationP1 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(player1.getFighterJumpDuration()));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player1.getListFighterJumpL().length-1));
                            p1.setImage(player1.getListFighterJumpL()[index]);
                        }
                    };
                    jumpAnimationP1.play();

                    jumpP1.setOnFinished(event -> {
                        p1.setY(303);
                        p1.setImage(player1.getImageFighterStanceL());
                        p1JumpAction = false;
                    });


                    wPressed.set(true);
                }

                // Player 1 punches
                if(e.getCode() == KeyCode.S && !p1PunchAction && !p1KickAction && !p1JumpAction && !sPressed.get())
                {
                    if(aPressed.get() || dPressed.get())
                    {
                        aPressed.set(false);
                        dPressed.set(false);
                    }
                    p1PunchAction = true;
                    Transition punchAnimationP1 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(player1.getFighterPunchDuration()));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player1.getListFighterPunchL().length-1));
                            p1.setImage(player1.getListFighterPunchL()[index]);
                        }
                    };
                    punchAnimationP1.play();
                    punchAnimationP1.setOnFinished(event -> {
                        p1.setImage(player1.getImageFighterStanceL());
                        p1PunchAction = false;
                    });
                    sPressed.set(true);

                }

                // Player 1 kicks
                if(e.getCode() == KeyCode.C && !p1KickAction && !p1PunchAction && !cPressed.get())
                {
                    if(aPressed.get() || dPressed.get())
                    {
                        aPressed.set(false);
                        dPressed.set(false);
                    }
                    p1KickAction = true;
                    double currentY = p1.getY();
                    p1.setY(p1.getY() - (player1.getListFighterKickR()[0].getHeight() - player1.getImageFighterStanceR().getHeight()));
                    Transition kickAnimationP1 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(player1.getFighterKickDuration()));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player1.getListFighterKickL().length-1));
                            p1.setImage(player1.getListFighterKickL()[index]);
                        }
                    };
                    kickAnimationP1.play();
                    kickAnimationP1.setOnFinished(event -> {
                        p1.setImage(player1.getImageFighterStanceL());
                        p1.setY(currentY);
                        p1KickAction = false;
                    });
                    cPressed.set(true);
                }

                // Player 2
                // Player 2 moves left
                if(e.getCode() == KeyCode.LEFT && !p2PunchAction && !p2KickAction)
                {
                    p2.setImage(player2.getImageFighterForwardR());
                    leftPressed.set(true);
                }

                // Player 2 moves right
                if(e.getCode() == KeyCode.RIGHT && !p2PunchAction && !p2KickAction)
                {
                    p2.setImage(player2.getImageFighterBackwardR());
                    rightPressed.set(true);
                }

                // Player 2 jumps
                if(e.getCode() == KeyCode.UP && !p2JumpAction && !p2PunchAction && !p2KickAction && !upPressed.get())
                {
                    p2JumpAction = true;
                    p2.setY(303 - (player2.getImageFighterJumpR().getHeight() - player2.getImageFighterStanceR().getHeight()));
                    TranslateTransition jumpP2 = new TranslateTransition(Duration.millis(player2.getFighterJumpDuration()), p2);
                    jumpP2.setByY(-300);
                    jumpP2.setAutoReverse(true);
                    jumpP2.setCycleCount(2);
                    jumpP2.play();

                    Transition jumpAnimationP2 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(player2.getFighterJumpDuration()));
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
                        p2JumpAction = false;
                    });

                    upPressed.set(true);

                }

                // Player 2 punches
                if(e.getCode() == KeyCode.DOWN && !p2PunchAction && !p2KickAction && !p2JumpAction && !downPressed.get())
                {
                    if(leftPressed.get() || rightPressed.get())
                    {
                        leftPressed.set(false);
                        rightPressed.set(false);
                    }
                    p2PunchAction = true;
                    double currentX = p2.getX();
                    p2.setX(p2.getX() - (player2.getImageFighterPunchR().getWidth() - player2.getImageFighterStanceR().getWidth()));
                    Transition punchAnimationP2 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(player2.getFighterPunchDuration()));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player2.getListFighterPunchR().length-1));
                            p2.setImage(player2.getListFighterPunchR()[index]);
                        }
                    };
                    punchAnimationP2.play();
                    punchAnimationP2.setOnFinished(event -> {
                        p2.setImage(player2.getImageFighterStanceR());
                        if (!leftPressed.get() && !rightPressed.get())
                        {
                            p2.setX(currentX);
                        }
                        p2PunchAction = false;
                    });
                    downPressed.set(true);

                }

                // Player 2 kicks
                if(e.getCode() == KeyCode.ENTER && !p2KickAction && !p2PunchAction && !p2JumpAction && !rightEnterPressed.get())
                {
                    if(leftPressed.get() || rightPressed.get())
                    {
                        leftPressed.set(false);
                        rightPressed.set(false);
                    }
                    p2KickAction = true;
                    double currentX = p2.getX();
                    double currentY = p2.getY();
                    p2.setX(p2.getX() - (player2.getListFighterKickR()[0].getWidth() - player2.getImageFighterStanceR().getWidth()));
                    p2.setY(p2.getY() - (player2.getListFighterKickR()[0].getHeight() - player2.getImageFighterStanceR().getHeight()));
                    Transition kickAnimationP2 = new Transition()
                    {
                        {
                            setCycleDuration(Duration.millis(player2.getFighterKickDuration()));
                        }
                        @Override
                        protected void interpolate(double frac)
                        {
                            int index = (int)(frac*(player2.getListFighterKickR().length-1));
                            p2.setImage(player2.getListFighterKickR()[index]);
                        }
                    };
                    kickAnimationP2.play();
                    kickAnimationP2.setOnFinished(event -> {
                        p2.setImage(player2.getImageFighterStanceR());
                        p2.setX(currentX);
                        p2.setY(currentY);
                        p2KickAction = false;
                    });
                    rightEnterPressed.set(true);
                }
            }
//            else
//                {
//                    System.exit(0);
//                }
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
            }

            if(e.getCode() == KeyCode.S)
            {
                sPressed.set(false);
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

            }

            if(e.getCode() == KeyCode.DOWN)
            {
                downPressed.set(false);
            }

            if(e.getCode() == KeyCode.ENTER)
            {
                rightEnterPressed.set(false);
            }

            if(player2.getHealth() <= 0 && !gameOver)
            {
                Transition winAnimationP1 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player1.getFighterWinDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player1.getListFighterWinL().length-1));
                        p1.setImage(player1.getListFighterWinL()[index]);
                    }
                };

                Transition koAnimationP2 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player2.getFighterKODuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player2.getListFighterKOR().length-1));
                        p2.setImage(player2.getListFighterKOR()[index]);
                    }
                };
                gameOver = true;
                winAnimationP1.play();
                koAnimationP2.play();
            }

            else if(player1.getHealth() <= 0 && !gameOver)
            {
                Transition winAnimationP2 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player2.getFighterWinDuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player2.getListFighterWinR().length-1));
                        p2.setImage(player2.getListFighterWinR()[index]);
                    }
                };

                Transition koAnimationP1 = new Transition()
                {
                    {
                        setCycleDuration(Duration.millis(player1.getFighterKODuration()));
                    }
                    @Override
                    protected void interpolate(double frac)
                    {
                        int index = (int)(frac*(player1.getListFighterKOL().length-1));
                        p1.setImage(player1.getListFighterKOL()[index]);
                    }
                };
                gameOver = true;
                winAnimationP2.play();
                koAnimationP1.play();
            }

        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Player 1
                if (dPressed.get() && p1.getX() <= 1200 - p1.getImage().getWidth() && p1.getX() < p2.getX())
                {
                    p1.setX((p1.getX() + 5));
                }

                if (aPressed.get() && p1.getX() >= 0)
                {
                    p1.setX((p1.getX() - 5));
                }

                // Player 2
                if (leftPressed.get() && p2.getX() >= 0 && p1.getX() < p2.getX())
                {
                    p2.setX((p2.getX() - 5));
                }

                if (rightPressed.get() && p2.getX() <= 1200 - p2.getImage().getWidth())
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
            }
        });

        cPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(cPressed.get())
            {
                if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
                {
                    player2.takeDamage(40);
                    p2HealthBar.setWidth(player2.getHealth());
                    p2HealthBar.setX(p2HealthBar.getX() + 40);
                }
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


        downPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(downPressed.get())
            {
                if (p2.getBoundsInParent().intersects(p1.getBoundsInParent()))
                            {
                                player1.takeDamage(20);
                                p1HealthBar.setWidth(player1.getHealth());
                            }
            }
        });

        rightEnterPressed.addListener((obs, wasPressed, nowPressed) ->
        {
            if(rightEnterPressed.get())
            {
                if (p2.getBoundsInParent().intersects(p1.getBoundsInParent()))
                {
                    player1.takeDamage(40);
                    p1HealthBar.setWidth(player1.getHealth());
                }
            }
        });
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