package kr.moble.java.mobleplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kr.moble.java.mobleplayer.service.FileService;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();

        FileService fileService = new FileService(primaryStage);
        String filePath = fileService.openFile();
        System.out.println(filePath);  // 콘솔에 파일 경로 출력

    }

    public static void main(String[] args) {
        launch();
    }
}