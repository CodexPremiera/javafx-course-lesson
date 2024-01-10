package Lesson07LoginLogout;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WelcomeLandingController {
    @FXML private Label greetingLabel;
    @FXML private Button logoutButton;
    @FXML private AnchorPane landingAnchor;

    Stage stage;

    public void displayUsername (String username) {
        greetingLabel.setText("Hello, " + username + "!");
    }

    /**
     * CLOSE CONFIRMATION FUNCTION
     * Pops up an alert box to ask for confirmation to close the program.
     * */
    public void logout () {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout.");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) landingAnchor.getScene().getWindow();
            stage.close();
        }
    }
}
