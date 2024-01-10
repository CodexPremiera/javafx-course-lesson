package Lesson07ControllerCommunication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeLoginController {
    @FXML
    private Label greetingLabel;

    public void displayUsername (String username) {
        greetingLabel.setText("Hello, " + username + "!");
    }
}
