module com.example.agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
            
                        requires org.kordamp.bootstrapfx.core;
    requires kotlin.stdlib;

    opens com.example.agenda to javafx.fxml;
    exports com.example.agenda;
}