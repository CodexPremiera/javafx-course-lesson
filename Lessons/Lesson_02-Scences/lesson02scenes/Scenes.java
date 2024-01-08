package lesson02scenes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * SCENE is a drawing surface for graphical content and a container for nodes.
 * */
public class Scenes extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 1080, 640, Color.rgb(164, 164, 144));

        stage.setTitle("lesson02scenes.Scenes");

        // Text
        Text text = new Text("Learn Graphical User Interface");
        text.setX(360);
        text.setY(160);
        text.setFont(Font.font("Helvetica", 24));
        text.setFill(Color.WHITE);
        root.getChildren().add(text);

        // Line
        Line line = new Line();
        line.setStartX(160);
        line.setStartY(100);
        line.setEndX(920);
        line.setEndY(540);
        line.setStroke(Color.WHEAT);
        line.setStrokeWidth(2);
        root.getChildren().add(line);

        // Rectangle
        Rectangle rectangle = new Rectangle(320, 195, 440, 250);
        rectangle.setFill(Color.rgb(255, 255, 255, 0.2));
        rectangle.setStroke(Color.WHEAT);
        rectangle.setStrokeWidth(2);
        root.getChildren().add(rectangle);

        // Image
        Image image = new Image(getClass().getResourceAsStream("/icon.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(460);
        imageView.setY(300);
        root.getChildren().add(imageView);

        stage.setScene(scene);
        stage.show();
    }
}
