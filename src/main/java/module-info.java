module com.example.tp2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tp2 to javafx.fxml;
    exports com.example.tp2.exo1;
}