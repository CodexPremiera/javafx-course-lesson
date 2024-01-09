module lesson01stages {
    requires javafx.controls;
    requires javafx.fxml;
            

    opens Lesson03SceneBuilder to javafx.fxml;

    exports Lesson01Stages;
    exports Lesson02Scenes;
    exports Lesson03SceneBuilder;
}