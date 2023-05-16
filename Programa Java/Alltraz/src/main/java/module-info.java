module com.example.alltraz {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.alltraz to javafx.fxml;
    exports com.example.alltraz;
}