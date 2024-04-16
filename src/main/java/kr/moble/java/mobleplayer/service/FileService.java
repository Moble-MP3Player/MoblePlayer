package kr.moble.java.mobleplayer.service;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * 파일 또는 폴더를 열어 경로를 반환하는 클래스
 */
public class FileService {
    private Stage primaryStage;

    public FileService(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * 파일 고르는 GUI를 생성하는 함수
     * @return 실패시 null, 고른 폴더의 경로를 반환
     */
    public String openFile() {
        FileChooser fileChooser = setupFileChooser(
                new FileChooser.ExtensionFilter("Music Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        File file = fileChooser.showOpenDialog(primaryStage);
        return file != null ? file.getPath() : null;
    }

    /**
     * 폴더를 고르는 GUI를 생성하는 함수
     * @return 실패시 null, 고른 폴더의 경로를 반환
     */
    public String selectDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(primaryStage);
        return directory != null ? directory.getPath() : null;
    }


    private FileChooser setupFileChooser(FileChooser.ExtensionFilter... filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(filters);
        return fileChooser;
    }
}