//package UserInterface;
//
//import javafx.scene.Group;
//import javafx.scene.ImageCursor;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//
//public class ControlsMenu
//{
//    private Scene cm;
//
//    public ControlsMenu(Stage stage)
//    {
//        Image imageBackground = new Image("/Assets/Menu/Start_Menu.gif");
//        ImageView background = new ImageView(imageBackground);
//
//        Image controlButtons = new Image("Assets/Menu/controlButtons.png");
//        ImageView controlPic = new ImageView(controlButtons);
//
//        Group characterMenuLayout = new Group();
//        characterMenuLayout.getChildren().addAll(background, controlPic);
//        Scene controls = new Scene(characterMenuLayout, 1200, 603);
//
//    }
//
//    public Scene getControlScene ()
//    {
//        return this.cm;
//    }
//}
