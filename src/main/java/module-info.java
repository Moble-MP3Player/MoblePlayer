module kr.moble.java.mobleplayer {
    requires javafx.controls;
    requires javafx.fxml;


    opens kr.moble.java.mobleplayer to javafx.fxml;
    exports kr.moble.java.mobleplayer;
}