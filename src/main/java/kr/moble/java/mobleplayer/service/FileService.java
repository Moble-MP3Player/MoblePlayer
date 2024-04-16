package kr.moble.java.mobleplayer.service;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileService {
    private Stage primaryStage;

    public FileService(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public String openFile() {
        FileChooser fileChooser = setupFileChooser(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Music Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.mpv", "*.mkv"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        File file = fileChooser.showOpenDialog(primaryStage);
        return file != null ? file.getPath() : "No file selected.";
    }

    public String saveFile() {
        FileChooser fileChooser = setupFileChooser(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.mpv", "*.mkv"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        File file = fileChooser.showSaveDialog(primaryStage);
        return file != null ? file.getPath() : "No file selected.";
    }

    public String selectDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File directory = directoryChooser.showDialog(primaryStage);
        return directory != null ? directory.getPath() : "No directory selected.";
    }

    private FileChooser setupFileChooser(FileChooser.ExtensionFilter... filters) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(filters);
        return fileChooser;
    }
}