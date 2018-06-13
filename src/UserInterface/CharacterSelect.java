package UserInterface;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.ImageCursor;

public class CharacterSelect
{

    public static Scene ShowCharacterSelect(Stage stage)
    {
        Image imageBackground = new Image("/Assets/Menu/Start_Menu.gif");
        Image imageCharSelectTitle = new Image("/Assets/character_selection.png");
        Image imageBack = new Image("/Assets/back.png");
        Image imageArrowLeft = new Image("/Assets/arrow_left.png");
        Image imageArrowRight = new Image("/Assets/arrow_right.png");
        Image imageAriesStance = new Image("/Assets/Aries/AriesStance.gif");
        Image imageKratosStance = new Image("/Assets/Kratos/KratosStance.gif");
        Image imageCharacterSelect = new Image("/Assets/character_selection.png");

        ImageView backgroundChar = new ImageView(imageBackground);
        backgroundChar.setX(0);
        backgroundChar.setY(0);
        backgroundChar.setFitHeight(603);
        backgroundChar.setFitWidth(1200);

        ImageView charSelectTitle = new ImageView(imageCharSelectTitle);
        charSelectTitle.setX(100);
        charSelectTitle.setY(-30);

        ImageView ariesStanceChar = new ImageView(imageAriesStance);
        ToggleButton ariesStanceCharButton = new ToggleButton("Aries", ariesStanceChar);
        ariesStanceCharButton.setStyle("-fx-background-color: transparent; -fx-font-size: 30px; -fx-text-fill: #FFF000");
        ariesStanceCharButton.setContentDisplay(ContentDisplay.TOP);
        ariesStanceCharButton.setLayoutX(300);
        ariesStanceCharButton.setLayoutY(100);
        ariesStanceCharButton.setMinWidth(156);
        ariesStanceCharButton.setMinHeight(222);
        ariesStanceCharButton.setOnAction(event -> System.out.println("a"));
        ariesStanceCharButton.setOnMouseEntered(event -> ariesStanceCharButton.setGraphic(new ImageView("/Assets/Aries/AriesMPunch.gif")));
        ariesStanceCharButton.setOnMouseExited(event -> ariesStanceCharButton.setGraphic(ariesStanceChar));
        ariesStanceCharButton.setOnAction(event -> stage.setScene(Menu.ShowMenu(stage)));

        ImageView kratosStanceChar = new ImageView(imageKratosStance);
        ToggleButton kratosStanceCharButton = new ToggleButton("Kratos", kratosStanceChar);
        kratosStanceCharButton.setStyle("-fx-background-color: transparent; -fx-font-size: 30px; -fx-text-fill: #FFF000");
        kratosStanceCharButton.setContentDisplay(ContentDisplay.TOP);
        kratosStanceCharButton.setLayoutX(674);
        kratosStanceCharButton.setLayoutY(100);
        kratosStanceCharButton.setMinWidth(226);
        kratosStanceCharButton.setMinHeight(222);
        kratosStanceCharButton.setOnAction(event -> System.out.println("k"));
        kratosStanceCharButton.setOnMouseEntered(event -> kratosStanceCharButton.setGraphic(new ImageView("/Assets/Kratos/KratosHPunch.gif")));
        kratosStanceCharButton.setOnMouseExited(event -> kratosStanceCharButton.setGraphic(kratosStanceChar));

        Button back = new Button();
        back.setGraphic(new ImageView(imageBack));
        back.setStyle("-fx-background-color: transparent;");
        back.setOnAction(event -> stage.setScene(Menu.ShowMenu(stage)));
        back.setOnMouseEntered(event -> back.setGraphic(new ImageView("/Assets/back_hover.png")));
        back.setOnMouseExited(event -> back.setGraphic(new ImageView("/Assets/back.png")));
        back.setLayoutX(0);
        back.setLayoutY(403);

        Group characterMenuLayout = new Group();
        characterMenuLayout.getChildren().addAll(backgroundChar, ariesStanceCharButton, kratosStanceCharButton, back, charSelectTitle);
        Scene characterSelect = new Scene(characterMenuLayout, 1200, 603);
        characterMenuLayout.setCursor(new ImageCursor(new Image ("/Assets/cursor.png")));
        return characterSelect;
    }

}
