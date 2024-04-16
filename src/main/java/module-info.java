module kr.moble.java.mobleplayer {
    requires javafx.controls;
    requires javafx.fxml;


    opens kr.moble.java.mobleplayer to javafx.fxml;
    exports kr.moble.java.mobleplayer;
    exports kr.moble.java.mobleplayer.controller;
    opens kr.moble.java.mobleplayer.controller to javafx.fxml;
}