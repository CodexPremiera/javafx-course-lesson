package Lesson07LoginLogout;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML TextField usernameField;
    @FXML Button loginButton;

    /**
     * LOGIN FUNCTION
     * Takes the inputted username from the text field #usernameField.
     * Upon clicking the login button, the WelcomeLanding.fxml scene is loaded
     * showing a greeting with username.
     * */
    public void login(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeLanding.fxml"));
        root = loader.load();

        WelcomeLandingController welcomeLoginController = loader.getController();
        welcomeLoginController.displayUsername(username);

        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
