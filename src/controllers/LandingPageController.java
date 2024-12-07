package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LandingPageController {

    @FXML
    private MenuItem FAQ;

    @FXML
    private MenuItem aboutStrokeAware;

    @FXML
    private Button btnAssessment;

    @FXML
    private Button btnLearnMore;

    @FXML
    private Label callToActionLabel;

    @FXML
    private Label createdByLabel;

    @FXML
    private HBox footerHBox;

    @FXML
    private Label githubLabel;

    @FXML
    private MenuButton helpButton;

    @FXML
    private Button homeButton;

    @FXML
    private MenuItem howToUse;

    @FXML
    private GridPane landingPagePane;

    @FXML
    private ImageView logoImage;

    @FXML
    private Label logoLabel;

    @FXML
    private HBox menuBar;

    @FXML
    private Button settingsButton;

    @FXML
    private Label taglineLabel;

    @FXML
    private Label versionLabel;

    @FXML
    void initialize() {
        Platform.runLater(() -> {
            landingPagePane.requestFocus();
        });
        Tooltip btnAssessmentTooltip = new Tooltip("Start your stroke risk assessment");
        btnAssessment.setTooltip(btnAssessmentTooltip);

        Tooltip btnLearnMoreTooltip = new Tooltip("Learn more about stroke risks and prevention");
        btnLearnMore.setTooltip(btnLearnMoreTooltip);

        Tooltip githubTooltip = new Tooltip("Visit the GitHub repository");
        githubLabel.setTooltip(githubTooltip);

        btnAssessmentTooltip.setShowDelay(Duration.millis(500));
        btnLearnMoreTooltip.setShowDelay(Duration.millis(500));
        githubTooltip.setShowDelay(Duration.millis(500));

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
    void onBeginAssessmentButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/AssessmentPage.fxml"));
            Scene newScene = new Scene(loader.load());
            Stage currentStage = (Stage) btnAssessment.getScene().getWindow();
            double currentX = currentStage.getX();
            double currentY = currentStage.getY();
            double currentWidth = currentStage.getWidth();
            double currentHeight = currentStage.getHeight();
            currentStage.setScene(newScene);
            currentStage.setX(currentX);
            currentStage.setY(currentY);
            currentStage.setWidth(currentWidth);
            currentStage.setHeight(currentHeight);
            String assessmentPageCSS = getClass().getResource("/views/assessmentPage.css").toExternalForm();
            newScene.getStylesheets().add((assessmentPageCSS));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void onLearnMoreButtonClick(ActionEvent event) {
        try {
            String url = "https://www.stroke.org/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
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
