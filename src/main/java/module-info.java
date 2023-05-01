module com.game.finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.finalproject to javafx.fxml;
    exports com.game.finalproject;
}