package UserInterface;

import Fighters.Aries;
import Fighters.Fighter;
import Fighters.Kratos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.ImageCursor;

public class CharacterSelectScreen
{
    private Scene sc;

    private ArenaSelectScreen arenaInfo;

    private Fighter player1, player2;

    private String player1Char = "";
    private String player2Char = "";

    private Arena arena;

    public CharacterSelectScreen(Stage stage)
    {

        // Initialize Required Images
        Image imageBackground = new Image("/Assets/Menu/Start_Menu.gif");
        Image imageCharSelectTitle = new Image("/Assets/character_selection.png");
        Image imageBack = new Image("/Assets/back.png");
        Image imageConfirm = new Image("/Assets/confirm.png");
        Image imageArrowLeft = new Image("/Assets/arrow_left.png");
        Image imageArrowRight = new Image("/Assets/arrow_right.png");
        Image imageAriesStance = new Image("/Assets/Aries/AriesStance.gif");
        Image imageKratosStance = new Image("/Assets/Kratos/KratosStance.gif");
        Image imageCharacterSelect = new Image("/Assets/character_selection.png");

        // Make Character Select Screen
        ImageView backgroundChar = new ImageView(imageBackground);
        backgroundChar.setX(0);
        backgroundChar.setY(0);
        backgroundChar.setFitHeight(603);
        backgroundChar.setFitWidth(1200);

        ImageView charSelectTitle = new ImageView(imageCharSelectTitle);
        charSelectTitle.setX(100);
        charSelectTitle.setY(-30);

        Button confirm = new Button("", new ImageView(imageConfirm));
        confirm.setLayoutX(780);
        confirm.setLayoutY(403);
        confirm.setStyle("-fx-background-color: transparent;");
        confirm.setOnMouseEntered(event -> confirm.setGraphic(new ImageView("/Assets/confirm_hover.png")));
        confirm.setOnMouseExited(event -> confirm.setGraphic(new ImageView(imageConfirm)));
        confirm.setOnAction(event -> {
            arena.setPlayer1(this.player1);
            arena.setPlayer2(this.player2);
            stage.setScene(this.arenaInfo.getArenaSelectScene());
        });
        confirm.setVisible(false);

        ImageView ariesStanceChar = new ImageView(imageAriesStance);
        ToggleButton ariesStanceCharButton = new ToggleButton("Aries", ariesStanceChar);
        ariesStanceCharButton.setStyle("-fx-background-color: transparent; -fx-font: 30px Papyrus; -fx-text-fill: #FFFFFF; -fx-font-weight: bold;");
        ariesStanceCharButton.setContentDisplay(ContentDisplay.TOP);
        ariesStanceCharButton.setLayoutX(300);
        ariesStanceCharButton.setLayoutY(100);
        ariesStanceCharButton.setMinWidth(156);
        ariesStanceCharButton.setMinHeight(222);
        ariesStanceCharButton.setOnAction(event -> {
            if (ariesStanceCharButton.isSelected() && this.player1Char.equals("") && this.player2Char.equals(""))
            {
                ariesStanceCharButton.setText("Aries - Player 1");
                this.player1Char = "Aries";

            }
            else if (ariesStanceCharButton.isSelected() && !this.player1Char.equals("") && !this.player1Char.equals("Aries") && this.player2Char.equals(""))
            {
                ariesStanceCharButton.setText("Aries - Player 2");
                this.player2Char = "Aries";
            }
            else if (!ariesStanceCharButton.isSelected() && !this.player1Char.equals("") && this.player2Char.equals("Aries"))
            {
                ariesStanceCharButton.setText("Aries");
                this.player2Char = "";
            }
            else if (!ariesStanceCharButton.isSelected() && this.player1Char.equals("Aries") && this.player2Char.equals(""))
            {
                ariesStanceCharButton.setText("Aries");
                this.player1Char = "";
            }
            if(!this.player1Char.equals("") && !this.player2Char.equals(""))
            {
                confirm.setVisible(true);
            }
            else
                {
                    confirm.setVisible(false);
                }
        });
        ariesStanceCharButton.setOnMouseEntered(event -> ariesStanceCharButton.setGraphic(new ImageView("/Assets/Aries/AriesMPunch.gif")));
        ariesStanceCharButton.setOnMouseExited(event -> ariesStanceCharButton.setGraphic(ariesStanceChar));

        ImageView kratosStanceChar = new ImageView(imageKratosStance);
        ToggleButton kratosStanceCharButton = new ToggleButton("Kratos", kratosStanceChar);
        kratosStanceCharButton.setStyle("-fx-background-color: transparent; -fx-font: 30px Papyrus; -fx-text-fill: #FFFFFF  ; -fx-font-weight: bold;");
        kratosStanceCharButton.setContentDisplay(ContentDisplay.TOP);
        kratosStanceCharButton.setLayoutX(674);
        kratosStanceCharButton.setLayoutY(100);
        kratosStanceCharButton.setMinWidth(226);
        kratosStanceCharButton.setMinHeight(222);
        kratosStanceCharButton.setOnAction(event -> {
            if (kratosStanceCharButton.isSelected() && this.player1Char.equals("") && this.player2Char.equals(""))
            {
                kratosStanceCharButton.setText("Kratos - Player 1");
                this.player1Char = "Kratos";

            }
            else if (kratosStanceCharButton.isSelected() && !this.player1Char.equals("") && !this.player1Char.equals("Kratos") && this.player2Char.equals(""))
            {
                kratosStanceCharButton.setText("Kratos - Player 2");
                this.player2Char = "Kratos";
            }
            else if (!kratosStanceCharButton.isSelected() && !this.player1Char.equals("") && this.player2Char.equals("Kratos"))
            {
                kratosStanceCharButton.setText("Kratos");
                this.player2Char = "";
            }
            else if (!kratosStanceCharButton.isSelected() && this.player1Char.equals("Kratos") && this.player2Char.equals(""))
            {
                kratosStanceCharButton.setText("Kratos");
                this.player1Char = "";
            }
            if(!this.player1Char.equals("") && !this.player2Char.equals(""))
            {
               confirm.setVisible(true);
            }
            else
                {
                    confirm.setVisible(false);
                }
        });
        kratosStanceCharButton.setOnMouseEntered(event -> kratosStanceCharButton.setGraphic(new ImageView("/Assets/Kratos/KratosHPunch.gif")));
        kratosStanceCharButton.setOnMouseExited(event -> kratosStanceCharButton.setGraphic(kratosStanceChar));


        Button back = new Button();
        back.setGraphic(new ImageView(imageBack));
        back.setStyle("-fx-background-color: transparent;");
        back.setOnAction(event -> stage.setScene(Menu.ShowMenu(stage, this)));
        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("/Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("/Assets/back.png")));
        back.setLayoutX(0);
        back.setLayoutY(403);

        Group characterMenuLayout = new Group();
        characterMenuLayout.getChildren().addAll(backgroundChar, ariesStanceCharButton, kratosStanceCharButton, back, charSelectTitle, confirm);
        Scene characterSelect = new Scene(characterMenuLayout, 1200, 603);
        characterMenuLayout.setCursor(new ImageCursor(new Image ("/Assets/cursor.png")));
        this.sc = characterSelect;
    }

    public Scene getCharSelectScene ()
    {
        return this.sc;
    }

    public void setCharacter(String p1, String p2)
    {
        if(p1.equals("Kratos"))
        {
            player1 = new Kratos();
        }
        else if(p2.equals("Kratos"))
        {
            player2 = new Kratos();
        }
        else if(p1.equals("Aries"))
        {
            player1 = new Aries();
        }
        else if(p2.equals("Aries"))
        {
            player2 = new Aries();
        }
    }

    public Fighter getPlayer1()
    {
        return player1;
    }

    public Fighter getPlayer2()
    {
        return player2;
    }

    public void setArenaSelect(ArenaSelectScreen ac)
    {
        this.arenaInfo = ac;
    }

    public void setArena(Arena arena)
    {
        this.arena = arena;
    }
}
