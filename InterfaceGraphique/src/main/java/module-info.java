module com.example.rpggraphic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example.rpggraphic to javafx.fxml;
    exports com.example.rpggraphic;
    exports com.example.rpggraphic.Controllers;
    opens com.example.rpggraphic.Controllers to javafx.fxml;
}