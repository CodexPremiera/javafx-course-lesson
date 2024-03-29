package Lesson01Stages;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;


public class Stages extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    /**
     * root = root node of the window. It holds all the elements of the window.
     * stage = resides in the window and holds the scenes
     * scene = the event within the stage
     * */
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.rgb(33, 33, 35));

        stage.setTitle("LernSpace");
        stage.setHeight(640);
        stage.setWidth(1080);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/Lesson01Stages/icon.png")));
        stage.getIcons().add(icon);

        stage.setFullScreen(false);
        stage.setFullScreenExitHint("Press x to exit fullscreen");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("x"));

        stage.setScene(scene);
        stage.show();
    }
}
