module com.example.wordguessergui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wordguessergui to javafx.fxml;
    exports com.example.wordguessergui;
}