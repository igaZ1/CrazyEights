package edu.ib;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * first view in the game
 */

public class startGameController{

    @FXML
    private StackPane rootPanel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStart;

    /**
     * fading view, the appearance of a second view - choose of number players
     */
    @FXML
    private void startGame(ActionEvent event) {
        makeFadeOut();
    }

    @FXML
    void initialize() {
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'StartGame.fxml'.";
    }

    /**
     * fading first view
     */
    private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setNode(rootPanel);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished(event -> loadChoosePlayersScene());
        fadeTransition.play();
    }

    /**
     * starting the second view
     */
    private void loadChoosePlayersScene(){

        try {
            Parent secondView;
            secondView = (StackPane) FXMLLoader.load(getClass().getResource("/fxml/choosePlayers.fxml"));

            Scene secondScene = new Scene(secondView);
            Stage curStage = (Stage) rootPanel.getScene().getWindow();
            curStage.setScene(secondScene);

        } catch (IOException e){
            Logger.getLogger(startGameController.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
