module com.example.alltraz2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.alltraz2 to javafx.fxml;
    exports com.example.alltraz2;
    exports sample;
    opens sample to javafx.fxml;
}