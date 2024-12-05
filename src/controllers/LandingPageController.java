package controllers;

import java.net.URI;
import java.awt.Desktop;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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
    private Label githubLabel;

    @FXML
    private GridPane landingPagePane;

    @FXML
    private ImageView logoImage;

    @FXML
    private Label logoLabel;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Label taglineLabel;

    @FXML
    private Label versionLabel;

    @FXML
    void openGitHub(MouseEvent event) {
          try {
            String url = "https://github.com/mcbaer23812/StrokePredictor"; // Replace with your GitHub link
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions
        }
    }

}
