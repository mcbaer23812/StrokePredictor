package controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AssessmentPageController {

    @FXML
    private GridPane assessmentPagePane;

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
    private HBox menuBar;

    @FXML
    private Button settingsButton;

    @FXML
    private Label versionLabel;

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
