module src {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.junit.jupiter.api;


    opens src to javafx.fxml;
    exports src;
    exports src.Humanoid;
    opens src.Humanoid to javafx.fxml;
}