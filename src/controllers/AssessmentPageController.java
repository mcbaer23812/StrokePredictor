package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AssessmentPageController {

    @FXML
    private TextField ageTextField;

    @FXML
    private GridPane assessmentPagePane;

    @FXML
    private ComboBox<String> genderComboBox;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Label createdByLabel;

    @FXML
    private HBox footerHBox;

    @FXML
    private Label githubLabel;

    @FXML
    private TextField glucoseTextField;

    @FXML
    private Button helpButton;

    @FXML
    private Button homeButton;

    @FXML
    private ComboBox<String> maritalStatusComboBox;

    @FXML
    private HBox menuBar;

    @FXML
    private ComboBox<String> residenceTypeComboBox;

    @FXML
    private Button settingsButton;

    @FXML
    private ComboBox<String> smokingStatusComboBox;

    @FXML
    private Label versionLabel;

    @FXML
    private ComboBox<String> workTypeComboBox;

    @FXML
    void initialize() {
        
        // textfield initialization
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

        glucoseTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.isEmpty()) {
                return change;
            }
            if (newText.matches("\\d{0,3}(\\.\\d{0,2})?")) {
                return change;
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
    void openGitHub(MouseEvent event) {
        try {
            String url = "https://github.com/mcbaer23812/StrokePredictor";
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
