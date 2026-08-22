module loveCounter {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.net.http;
    
    opens loveCounter to javafx.fxml;
    exports loveCounter;
}
