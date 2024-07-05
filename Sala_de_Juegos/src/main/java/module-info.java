module com.mycompany.sala_de_juegos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.mycompany.sala_de_juegos to javafx.fxml;
    exports com.mycompany.sala_de_juegos;
}
