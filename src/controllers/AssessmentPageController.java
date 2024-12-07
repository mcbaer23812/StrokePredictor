package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AssessmentPageController {

 @FXML
    private MenuItem FAQ;

    @FXML
    private MenuItem aboutStrokeAware;

    @FXML
    private TextField ageTextField;

    @FXML
    private GridPane assessmentPagePane;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Label createdByLabel;

    @FXML
    private HBox footerHBox;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private Label githubLabel;

    @FXML
    private TextField glucoseTextField;

    @FXML
    private CheckBox heartDiseaseCheckBox;

    @FXML
    private MenuButton helpButton;

    @FXML
    private Button homeButton;

    @FXML
    private MenuItem howToUse;

    @FXML
    private CheckBox hypertensionCheckBox;

    @FXML
    private ComboBox<String> maritalStatusComboBox;

    @FXML
    private HBox menuBar;

    @FXML
    private Button resetButton;

    @FXML
    private ComboBox<String> residenceTypeComboBox;

    @FXML
    private Button settingsButton;

    @FXML
    private ComboBox<String> smokingStatusComboBox;

    @FXML
    private Button submitButton;

    @FXML
    private Label versionLabel;

    @FXML
    private ComboBox<String> workTypeComboBox;

    @FXML
    void initialize() {

        // allows for age to be 0-120
        ageTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) {
                return change;
            }
            if (newText.matches("\\d{0,3}")) {
                try {
                    int ageValue = Integer.parseInt(newText);
                    if (ageValue <= 120) {
                        return change;
                    }
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
        }));

        // allows for bmi to be 0.0-60.0
        bmiTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) {
                return change;
            }
            if (newText.matches("\\d{0,2}(\\.\\d?)?")) {
                try {
                    double bmiValue = Double.parseDouble(newText);
                    if (bmiValue <= 60) {
                        return change;
                    }
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
        }));

        // allows for glucose to be 0.00-300.00
        glucoseTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) {
                return change;
            }
            if (newText.matches("\\d{0,3}(\\.\\d{0,2})?")) {
                try {
                    double averageGlucoseValue = Double.parseDouble(newText);
                    if (averageGlucoseValue <= 300) {
                        return change;
                    }
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
        }));

        // combobox initialization
        genderComboBox.getItems().removeAll(genderComboBox.getItems());
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        smokingStatusComboBox.getItems().removeAll(smokingStatusComboBox.getItems());
        smokingStatusComboBox.getItems().addAll("Formerly Smoked", "Never Smoked", "Smokes", "Unknown");

        maritalStatusComboBox.getItems().removeAll(maritalStatusComboBox.getItems());
        maritalStatusComboBox.getItems().addAll("Yes", "No");

        workTypeComboBox.getItems().removeAll(workTypeComboBox.getItems());
        workTypeComboBox.getItems().addAll("Private Company", "Government Job", "Self-Employed", "Never Worked",
                "Children");

        residenceTypeComboBox.getItems().removeAll(residenceTypeComboBox.getItems());
        residenceTypeComboBox.getItems().addAll("Rural", "Urban");
    }

    @FXML
    void onAboutStrokeAwareClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About StrokeAware");
        alert.setHeaderText("About StrokeAware");
        alert.setContentText(
                "StrokeAware helps assess your stroke risk using a machine learning model based on your input data.");
        alert.showAndWait();
    }

    @FXML
    void onFaqClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("FAQs");
        alert.setHeaderText("Frequently Asked Questions");
        alert.setContentText("Q: What is BMI?\nA: BMI stands for Body Mass Index. It is used to calculate obesity.\n\nQ: What does Average Glucose Level mean?\nA: It refers to your average blood sugar level.");
        alert.showAndWait();
    }

    @FXML
    void onHomeButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/LandingPage.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage currentStage = (Stage) homeButton.getScene().getWindow();
            double currentX = currentStage.getX();
            double currentY = currentStage.getY();
            double currentWidth = currentStage.getWidth();
            double currentHeight = currentStage.getHeight();
            currentStage.setScene(newScene);
            currentStage.setX(currentX);
            currentStage.setY(currentY);
            currentStage.setWidth(currentWidth);
            currentStage.setHeight(currentHeight);
            currentStage.setScene(newScene);
            String landingPageCSS = getClass().getResource("/views/landingPage.css").toExternalForm();
            newScene.getStylesheets().add((landingPageCSS));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void onHowToUseClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("How to Use StrokeAware");
        alert.setHeaderText("How to Use StrokeAware");
        alert.setContentText("1. Fill out the required fields.\n2. Click Submit to calculate your risk.\n3. Review the results.\n");
        alert.showAndWait();
    }

    @FXML
    void onResetButtonClick(ActionEvent event) {
        // textfields
        ageTextField.clear();
        bmiTextField.clear();
        glucoseTextField.clear();

        // comboboxes
        genderComboBox.setValue(null);
        smokingStatusComboBox.setValue(null);
        maritalStatusComboBox.setValue(null);
        workTypeComboBox.setValue(null);
        residenceTypeComboBox.setValue(null);

        // checkboxes
        hypertensionCheckBox.setSelected(false);
        heartDiseaseCheckBox.setSelected(false);
    }

    @FXML
    void onSubmitButtonClick(ActionEvent event) {
        try {
            String age = ageTextField.getText();
            String gender = genderComboBox.getValue();
            String bmi = bmiTextField.getText();
            String glucose = glucoseTextField.getText();
            String smokingStatus = smokingStatusComboBox.getValue();
            boolean hasHypertension = hypertensionCheckBox.isSelected();
            boolean hasHeartDisease = heartDiseaseCheckBox.isSelected();
            String maritalStatus = maritalStatusComboBox.getValue();
            String workType = workTypeComboBox.getValue();
            String residenceType = residenceTypeComboBox.getValue();

            // error if any field is empty
            if (age.isEmpty() || gender == null || bmi.isEmpty() || glucose.isEmpty() || smokingStatus == null ||
                    maritalStatus == null || workType == null || residenceType == null) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Input Validation Error");
                alert.setHeaderText("Incomplete Fields");
                alert.setContentText("Please fill out all fields before submitting.");
                alert.showAndWait();
                return;

            }

            int ageValue = Integer.parseInt(age);
            double bmiValue = Double.parseDouble(bmi);
            double glucoseValue = Double.parseDouble(glucose);

            // BEGIN DATA PROCESSING

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input. Please check your entries.");
        }
    }

    @FXML
    void openGitHub(MouseEvent event) {
        try {
            String url = "https://github.com/mcbaer23812/StrokePredictor";
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
