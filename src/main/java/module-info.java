module com.example.tugastesting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tugastesting to javafx.fxml;
    exports com.example.tugastesting;
}