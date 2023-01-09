module com.example.hvg {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.hvg to javafx.fxml;
    exports com.example.hvg;
    exports com.example.hvg.humanoid;
    exports com.example.hvg.equipment;
}