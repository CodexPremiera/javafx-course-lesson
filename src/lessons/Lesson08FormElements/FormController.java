package Lesson08FormElements;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML GridPane formGrid;

    /**
     * IMAGE VIEW
     * = a container that encapsulates an image file in JavaFX.
     * <p>
     * The Pane imagePane (grid 1) contains an image view flanked by two arrow buttons.
     * When pressing either buttons, the image view will display the next or prev image.
     */
    @FXML Pane imagePane;
    @FXML ImageView imageView;
    @FXML Button imagePrevButton;
    @FXML Button imageNextButton;

    private final Image[] images = {
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/f22.jpg"))),
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/f35.jpg"))),
            new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/b2.jpg")))
    };
    private int currentImageNumber = 0;

    public void displayNextImage() {
        currentImageNumber = (currentImageNumber < images.length - 1) ? currentImageNumber + 1 : 0;
        imageView.setImage(images[currentImageNumber]);
    }

    public void displayPrevImage() {
        currentImageNumber = (currentImageNumber > 0) ? currentImageNumber - 1 : images.length - 1;
        imageView.setImage(images[currentImageNumber]);
    }


    /**
     * COLOR PICKER
     * = a choice box that allows the user to select a color
     * <p>
     * The Pane colorPane (grid 2) contains a color picker.
     * The pane is then colored with the color that is picked.
     */
    @FXML Pane colorPane;
    @FXML ColorPicker colorPicker;

    public void setPaneColor() {
        colorPane.setBackground(Background.fill(colorPicker.getValue()));
    }


    /**
     * DATE PICKER
     * = a choice box that allows the user to select a date
     * <p>
     * The Pane datePane (grid 3) contains a date picker.
     * The picked date is then displayed in the date label.
     */
    @FXML Pane datePane;
    @FXML DatePicker datePicker;
    @FXML Label dateLabel;

    public void displayDate() {
        LocalDate date = datePicker.getValue();
        String dateText = date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        dateLabel.setText("Your birthday is on " + dateText);
    }


    /**
     * CHECKBOX
     * = a toggle box that returns true if  selected and false if not.
     * <p>
     * The Pane checkPane (grid 4) contains an image view of a bulb
     * with a checkbox as the 'switch' on its right.
     * If selected, image of an on-bulb is shown. Otherwise, an off-bulb.
     */
    @FXML Pane checkPane;
    @FXML ImageView checkBulb;
    @FXML CheckBox checkBulbSwitch;

    Image onBulb = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/lightbulb-on.png")));
    Image offBulb = new Image(Objects.requireNonNull(getClass().getResourceAsStream("images/lightbulb-off.png")));

    public void checkSwitch() {
        checkBulb.setImage(checkBulbSwitch.isSelected() ? onBulb : offBulb);
    }


    /**
     * RADIO BUTTON
     * = a series of toggle box that allows users to select one unique choice
     * <p>
     * The Pane radioPane (grid 5) contains an image view of a bulb
     * with two radio boxes as on/off buttons on its right.
     * If on is selected, image of an on-bulb is shown. Otherwise, an off-bulb.
     */
    @FXML Pane radioPane;
    @FXML ImageView radioBulb;
    @FXML RadioButton radioBulbOn, radioBulbOff;
    @FXML ToggleGroup radioBulbSwitch;

    public void radioSwitch() {
        if (radioBulbOn.isSelected())
            radioBulb.setImage(onBulb);
        else if (radioBulbOff.isSelected())
            radioBulb.setImage(offBulb);
    }


    /**
     * CHOICE BOX
     * = a dropdown menu that allows users to select item
     * <p>
     * The Pane choicePane (grid 6) contains an image view of a bulb
     * with a choice box on its right containing on/off items.
     * If on is selected, image of an on-bulb is shown. Otherwise, an off-bulb.
     */
    @FXML Pane choicePane;
    @FXML ImageView choiceBulb;
    @FXML ChoiceBox<String> choiceBulbSwitch;

    private final String[] choices = new String[]{"On", "Off"};

    // for method, see initialize() below

    public void choiceSwitch(ActionEvent actionEvent) {
        String choice = choiceBulbSwitch.getValue();
        if (choice.equals("On"))
            choiceBulb.setImage(onBulb);
        else if (choice.equals("Off"))
            choiceBulb.setImage(offBulb);
    }


    /**
     * CHECKBOX
     * = a box that allows users to type text
     * <p>
     * The Pane textPane (grid 7) contains a text field that takes the age of the user.
     * It verifies if the input is a text. Only then it accepts.
     */
    @FXML Pane textPane;
    @FXML TextField textField;
    @FXML Button textSubmitButton;
    @FXML Text textLabel;

    public void submitAge(ActionEvent actionEvent) {
        try {
            int age = Integer.parseInt(textField.getText());
            String remark;

            if (age < 0)
                remark = "Ages must be positive.";
            else if (age > 125)
                remark = "Ages are unlikely to be above 125.";
            else
                remark = "You are " + age + " years old. " + ((age >= 18) ? "You are an adult" : "You are a minor.");

            textLabel.setText(remark);
        } catch (NumberFormatException numberFormatException) {
            textLabel.setText("Please enter a valid number.");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * SLIDER
     * = a slider is a line range selector that allows users to select a value
     * by sliding the slider bar.
     * <p>
     * The Pane sliderPane (grid 8) contains a slider with values from 1 to 10.
     * The value selected is displayed in the slider label.
     */
    @FXML Pane sliderPane;
    @FXML Slider slider;
    @FXML Label sliderLabel;

    // for method, see initialize() below


    /**
     * SPINNER
     * = a slider is a single text field that allows users to select an item
     * from an ordered sequence.
     * <p>
     * The Pane spinnerPane (grid 9) contains a spinner with values from 1 to 10.
     * The value selected is displayed in the spinner label.
     */
    @FXML Pane spinnerPane;
    @FXML Label spinnerLabel;
    @FXML Spinner<Integer> spinner;

    int currentValue;

    // for method, see initialize() below


    /**
     * THE INITIALIZER METHOD
     * = initializes the behaviour of certain JavaFX elements that
     * can't be modified in detail using scene builder.
     * <p>
     * For the choice box, it adds the choices from a collection,
     * sets default to "off", and adds an onAction method.
     * <p>
     * For the slider, it initializes the display on the label and
     * adds a change listener.
     * <p>
     * For the spinner, it sets the range of options and adds a change listener.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Choice Box
        choiceBulbSwitch.getItems().addAll(choices);
        choiceBulbSwitch.setValue("Off");
        choiceBulbSwitch.setOnAction(this::choiceSwitch);

        // Slider
        int rate = (int) slider.getValue();
        sliderLabel.setText("You choose " + rate);

        slider.valueProperty().addListener((observableValue, number, t1) -> {
            int rate1 = (int) slider.getValue();
            sliderLabel.setText("You choose " + rate1);
        });

        // Spinner
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        spinner.setValueFactory(valueFactory);

        spinner.valueProperty().addListener((observableValue, integer, t1) -> {
            currentValue = spinner.getValue();
            spinnerLabel.setText("Your number is: " + currentValue);
        });
    }
}