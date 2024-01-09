package Lesson04EventHandling;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class EventController {
    @FXML
    private Circle circle;
    private double x;
    private double y;

    public void up(ActionEvent actionEvent) {
        circle.setCenterY(y-=10);
        //System.out.println("Up");
    }
    public void down(ActionEvent actionEvent) {
        circle.setCenterY(y+=10);
        //System.out.println("Down");
    }
    public void left(ActionEvent actionEvent) {
        circle.setCenterX(x-=10);
        //System.out.println("Left");
    }
    public void right(ActionEvent actionEvent) {
        circle.setCenterX(x+=10);
        //System.out.println("Right");
    }
}
