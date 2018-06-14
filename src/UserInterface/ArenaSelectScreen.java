package UserInterface;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ArenaSelectScreen
{

    Scene arena;
    Image arenaChoice;

    public ArenaSelectScreen(Stage stage)
    {

        Image imageBackground = new Image("/Assets/Menu/Start_Menu.gif");
        Image imageBgOption1 = new Image("/Assets/Background1.gif");
        Image imageBgOption2 = new Image("/Assets/Background2.gif");
        Image imageArrowLeft = new Image("/Assets/arrow_left.png");
        Image imageArrowRight = new Image("/Assets/arrow_right.png");

        ImageView background = new ImageView(imageBackground);
        background.setX(0);
        background.setY(0);
        background.setFitHeight(603);
        background.setFitWidth(1200);

        ImageView BgOption = new ImageView(imageBgOption1);
        BgOption.setFitHeight(301.5);
        BgOption.setFitWidth(600);
        BgOption.setX(301.5);
        BgOption.setY(150);
        BgOption.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 5;");

        Button arrowLeft = new Button("", new ImageView(imageArrowLeft));
        arrowLeft.setLayoutX(100);
        arrowLeft.setLayoutY(251.5);
        arrowLeft.setStyle("-fx-background-color: transparent;");

        Button arrowRight = new Button("", new ImageView(imageArrowRight));
        arrowRight.setLayoutX(1000);
        arrowRight.setLayoutY(251.5);
        arrowRight.setStyle("-fx-background-color: transparent;");

        arrowLeft.setOnAction(event -> {
            if(BgOption.getImage() == imageBgOption1)
            {
                BgOption.setImage(imageBgOption1);
            }
            else if(BgOption.getImage() == imageBgOption2)
            {
                BgOption.setImage(imageBgOption1);
                arrowRight.setVisible(true);
            }
        } );
        arrowLeft.setOnMouseEntered(event -> arrowLeft.setGraphic(new ImageView("/Assets/arrow_left_hover.png")));
        arrowLeft.setOnMouseExited(event -> arrowLeft.setGraphic(new ImageView(imageArrowLeft)));

        arrowRight.setOnAction(event ->
        {
            if(BgOption.getImage() == imageBgOption1)
            {
                BgOption.setImage(imageBgOption2);
                arrowRight.setVisible(false);
            }
        });
        arrowRight.setOnMouseEntered(event -> arrowRight.setGraphic(new ImageView("/Assets/arrow_right_hover.png")));
        arrowRight.setOnMouseExited(event -> arrowRight.setGraphic(new ImageView(imageArrowRight)));

        Button selectMap = new Button("Choose Map");
        selectMap.setLayoutX(301.5);
        selectMap.setLayoutY(503);
        selectMap.setOnAction(event -> setArena((BgOption.getImage())));



        Group arenaSelectLayout = new Group();
        arenaSelectLayout.getChildren().addAll(background, BgOption, arrowLeft, arrowRight, selectMap);
        Scene arenaSelect = new Scene(arenaSelectLayout, 1200, 603);
        arenaSelect.setCursor(new ImageCursor(new Image( "/Assets/cursor.png")));
        this.arena = arenaSelect;
    }

    public Scene getArenaSelectScene()
    {
        return this.arena;
    }

    public void setArena(Image chosenMap)
    {
        this.arenaChoice = chosenMap;
    }

    public Image getArenaChoice()
    {
        return this.arenaChoice;
    }
}
