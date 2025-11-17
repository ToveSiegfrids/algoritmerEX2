module com.example.algoritmerex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    exports algortimer2;
  opens algortimer2 to javafx.fxml;

}