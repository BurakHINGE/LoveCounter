module loveCounter {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens loveCounter to javafx.fxml;
    exports loveCounter;
}
