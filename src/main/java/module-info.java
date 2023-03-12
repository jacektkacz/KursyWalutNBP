module com.example.kursywalutnbp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires org.apache.poi.ooxml;


    opens com.example.kursywalutnbp to javafx.fxml;
    exports com.example.kursywalutnbp;
}