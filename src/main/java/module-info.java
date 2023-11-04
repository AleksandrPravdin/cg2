module com.example.task02_07 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task02_07 to javafx.fxml;
    exports com.example.task02_07;
}