package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LandingPageController {


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
    private Button helpButton;

    @FXML
    private Button homeButton;

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
