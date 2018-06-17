package UserInterface;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Menu
{

    private Scene startMenu;
    private CharacterSelectScreen characterSelectScreen;
    private ControlsMenu controlsMenu;

    public Menu(Stage stage)
    {
        // Initialize required images
        Image imageBackground = new Image("/Assets/Menu/Start_Menu.gif");
        Image imageStart = new Image("/Assets/Menu/start.png");
        Image imageHelp = new Image("/Assets/Menu/help.png");
        Image imageQuit = new Image("/Assets/Menu/quit.png");
        Image imageTitle = new Image("/Assets/Menu/title.png");
        Image imageControl = new Image("/Assets/Menu/control.png");
        Image imageAriesStance = new Image("/Assets/Aries/AriesStance.gif");
        Image imageKratosStance = new Image("/Assets/Kratos/KratosStanceRight.gif");

        // Make Start Menu
        ImageView backgroundMenu = new ImageView(imageBackground);
        backgroundMenu.setX(0);
        backgroundMenu.setY(0);
        backgroundMenu.setFitHeight(603);
        backgroundMenu.setFitWidth(1200);

        ImageView title = new ImageView(imageTitle);
        title.setX(100);
        title.setY(50);
        title.setOnMouseEntered(event -> {
            title.setFitHeight(320);
            title.setFitWidth(1020);
        });
        title.setOnMouseExited(event -> {
            title.setFitHeight(300);
            title.setFitWidth(1000);
        });

        Button start = new Button();
        start.setGraphic(new ImageView(imageStart));
        start.setStyle("-fx-background-color: transparent; ");
        start.setOnAction(event -> stage.setScene(this.characterSelectScreen.getCharacterSelectScene()));
        start.setOnMouseEntered(event -> start.setGraphic(new ImageView("/Assets/Menu/start_hover.png")));
        start.setOnMouseExited(event -> start.setGraphic(new ImageView(imageStart)));
        start.setLayoutX(525);
        start.setLayoutY(300);

        Button help = new Button();
        help.setGraphic(new ImageView(imageHelp));
        help.setStyle("-fx-background-color: transparent; ");
        help.setOnMouseEntered(event -> help.setGraphic(new ImageView("/Assets/Menu/help_hover.png")));
        help.setOnMouseExited(event -> help.setGraphic(new ImageView(imageHelp)));
        help.setLayoutX(465);
        help.setLayoutY(375);


        Button control = new Button();
        control.setGraphic(new ImageView(imageControl));
        control.setStyle("-fx-background-color: transparent; ");
        control.setOnAction(event -> stage.setScene(this.controlsMenu.getControlScene()));
        control.setOnMouseEntered(event -> control.setGraphic(new ImageView("Assets/Menu/control_hover.png")));
        control.setOnMouseExited(event -> control.setGraphic(new ImageView(imageControl)));
        control.setLayoutX(465);
        control.setLayoutY(375);


        Button quit = new Button();
        quit.setGraphic(new ImageView(imageQuit));
        quit.setStyle("-fx-background-color: transparent; ");
        quit.setOnAction(event -> System.exit(0));
        quit.setOnMouseEntered(event -> quit.setGraphic(new ImageView("/Assets/Menu/quit_hover.png")));
        quit.setOnMouseExited(event -> quit.setGraphic(new ImageView(imageQuit)));
        quit.setLayoutX(465);
        quit.setLayoutY(450);

        ImageView ariesStanceMenu = new ImageView(imageAriesStance);
        ariesStanceMenu.setX(200);
        ariesStanceMenu.setY(325);

        ImageView kratosStanceMenu = new ImageView(imageKratosStance);
        kratosStanceMenu.setX(774);
        kratosStanceMenu.setY(325);

        Group startMenuLayout = new Group();
        startMenuLayout.getChildren().addAll(backgroundMenu, title, start, quit, control, ariesStanceMenu, kratosStanceMenu);
        startMenu = new Scene(startMenuLayout, 1200, 603);

        startMenu.setCursor(new ImageCursor(new Image( "/Assets/cursor.png")));
    }

    public Scene getStartMenu()
    {
        return this.startMenu;
    }

    public void setCharacterSelectScreen(CharacterSelectScreen cs)
    {
        this.characterSelectScreen = cs;
    }

    public void setControlsMenu(ControlsMenu cm)
    {
        this.controlsMenu = cm;
    }
}
