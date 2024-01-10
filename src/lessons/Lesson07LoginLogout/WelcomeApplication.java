package Lesson07LoginLogout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class WelcomeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("WelcomeLogin.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            /**
             * CLOSE CONFIRMATION
             * Uses a lambda function to ask for confirmation to close upon clicking the 'X' button.
             * */
            stage.setOnCloseRequest(windowEvent -> {
                windowEvent.consume();
                logout(stage);
            });

        } catch (Exception exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }
    }

    /**
     * CLOSE CONFIRMATION FUNCTION
     * Pops up an alert box to ask for confirmation to close the program.
     * */
    public void logout (Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout.");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
        }
    }
}
