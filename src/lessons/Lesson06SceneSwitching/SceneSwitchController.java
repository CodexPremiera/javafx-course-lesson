package Lesson06SceneSwitching;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitchController {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene1(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene01.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene02.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
