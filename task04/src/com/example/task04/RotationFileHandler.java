package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String filePath;
    private final ChronoUnit rotationUnit;

    public RotationFileHandler(String filePath, ChronoUnit rotationUnit) {
        this.filePath = filePath;
        this.rotationUnit = rotationUnit;
    }

    @Override
    public void HandleMessage(String message) {
        LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(rotationUnit);
        String fileName = filePath + currentDateTime.toString().replace(':', '#') + ".txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName))) {
            fileOutputStream.write(message.getBytes());
        } catch (IOException ex) {
            System.err.println("Error writing to log file: " + ex.getMessage());
        }
    }
}
