package com.example.hvg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class controls the UI for the settings page
 *
 * @author Cole Glass
 */
public class SettingsController {
    @FXML
    private Slider board_size_slider = new Slider();
    @FXML
    private Slider num_of_humans_slider = new Slider();
    @FXML
    private Slider num_of_goblins_slider = new Slider();
    @FXML
    private Slider game_type_slider = new Slider();
    @FXML
    private Button back_button;

    private Settings settings;

    /**
     * Initializes the page to values according to the settings
     */
    @FXML
    public void initialize() {
        settings = Settings.getSettings();
        board_size_slider.setValue(settings.getBoardSize());
        num_of_humans_slider.setValue(settings.getNumberOfHumans());
        num_of_goblins_slider.setValue(settings.getNumberOfGoblins());
        game_type_slider.setValue(settings.isAiGame() ? 1 : 0);

        board_size_slider.valueProperty().addListener((observableValue, number, t1) -> settings.setBoardSize((int) board_size_slider.getValue()));
        num_of_humans_slider.valueProperty().addListener((observableValue, number, t1) -> settings.setNumberOfHumans((int) num_of_humans_slider.getValue()));
        num_of_goblins_slider.valueProperty().addListener((observableValue, number, t1) -> settings.setNumberOfGoblins((int) num_of_goblins_slider.getValue()));
        game_type_slider.valueProperty().addListener((observableValue, number, t1) -> settings.setAiGame(game_type_slider.getValue() == 1));
    }

    /**
     * Navigates the user back to the main menu if the setting are valid
     *
     * @throws IOException
     */
    public void backToMain() throws IOException {
        if (settings.getBoardSize() >= settings.getNumberOfHumans() && settings.getBoardSize() >= settings.getNumberOfGoblins()) {
            Stage stage = (Stage) back_button.getScene().getWindow();
            stage.close();
            Stage mainStage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-view.fxml")));
            mainStage.setTitle("Humans VS Goblins");
            mainStage.setScene(new Scene(root, 600, 400));
            mainStage.show();
        } else {
            Stage popUp = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bad-settings-view.fxml")));
            popUp.setTitle("Error");
            popUp.setScene(new Scene(root, 350, 100));
            popUp.show();
        }
    }
}
