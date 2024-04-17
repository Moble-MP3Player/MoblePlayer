package kr.moble.java.mobleplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MoblePlayerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MoblePlayerApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

//        FileService fileService = new FileService(stage);
//        String filePath = fileService.openFile();
//        System.out.println(filePath);  // 콘솔에 파일 경로 출
    }

    public static void main(String[] args) {
        launch();
    }
}