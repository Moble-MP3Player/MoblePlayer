package kr.moble.java.mobleplayer.service;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    /**
     * FileChooser 을 생성할 때, 옵션을 줄 수 있는 ExtensionFilter를 초기화하고, FilerChooser 객체를 반환하는 함수
     * @param filters 파일 옵션에 대해 지정함
     * @return FileChooser
     */
    private FileChooser setupFileChooser(FileChooser.ExtensionFilter... filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(filters);
        return fileChooser;
    }

    /**
     * 해당 폴더 경로에 해당하는 MP3 파일들을 List로 반환
     * @param directoryPath 탐색할 폴더 경로
     * @return List<String> MP3파일 리스트
     */
    public List<String> searchMp3FilesInDirectory(String directoryPath) {
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            return paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".mp3")) // MP3 파일인지
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("MediaPlayerService(70) 디렉토리 파일 읽기 불가");
        }
    }
}