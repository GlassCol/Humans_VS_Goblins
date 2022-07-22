package com.example.hvg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Class to control the main menu of the game
 *
 * @author Cole Glass
 */
public class MainController {

    @FXML
    private Button settings_button;

    @FXML
    public void onExitButtonClick() {
        System.exit(0);
    }

    /**
     * Navigates the user from the main menu to the settings menu
     */
    @FXML
    public void goToSettings() throws IOException {
        Stage stage = (Stage) settings_button.getScene().getWindow();
        stage.close();
        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings-view.fxml")));
        mainStage.setTitle("Humans VS Goblins");
        mainStage.setScene(new Scene(root, 600, 400));
        mainStage.show();
    }

    /**
     * Creates & displays the scene for the main menu
     */
    @FXML
    public void startGame() throws IOException {
        Stage stage = (Stage) settings_button.getScene().getWindow();
        stage.close();
        Stage mainStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game-view.fxml")));
        mainStage.setTitle("Humans VS Goblins");
        mainStage.setScene(new Scene(root, 600, 400));
        mainStage.show();
    }
}
