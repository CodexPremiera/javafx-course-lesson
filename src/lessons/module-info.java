module lesson01stages {
    requires javafx.controls;
    requires javafx.fxml;

    opens Lesson03SceneBuilder to javafx.fxml;
    opens Lesson04EventHandling to javafx.fxml;
    opens Lesson05Stylesheets to javafx.fxml;
    opens Lesson06SceneSwitching to javafx.fxml;

    exports Lesson01Stages;
    exports Lesson02Scenes;
    exports Lesson03SceneBuilder;
    exports Lesson04EventHandling;
    exports Lesson05Stylesheets;
    exports Lesson06SceneSwitching;
}