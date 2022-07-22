module src {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;

    opens tests to org.junit.jupiter.api;
    exports tests;
    opens src to javafx.fxml;
    opens src.equipment to javafx.fxml;
    opens src.humanoid to javafx.fxml;
    exports src;
    exports src.humanoid;
    exports src.equipment;

}