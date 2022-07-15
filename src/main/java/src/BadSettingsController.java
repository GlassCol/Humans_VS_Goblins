package src;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BadSettingsController {
    @FXML
    private Button ok_button;

    public void accept() {
        Stage stage = (Stage) ok_button.getScene().getWindow();
        stage.close();
    }
}
