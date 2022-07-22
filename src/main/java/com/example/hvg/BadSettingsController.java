package com.example.hvg;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BadSettingsController {
    @FXML
    private Button ok_button;

    /**
     * Closes the window when the user clicks the accept button
     */
    public void accept() {
        Stage stage = (Stage) ok_button.getScene().getWindow();
        stage.close();
    }
}
