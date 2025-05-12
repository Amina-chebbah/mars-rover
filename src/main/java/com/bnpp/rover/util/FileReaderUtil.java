package com.bnpp.rover.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Utility class to read lines from a file.
 */
public class FileReaderUtil {

    /**
     * Reads all lines from a file path.
     * @param filePath the file path as a string
     * @return list of lines from the file
     * @throws IllegalArgumentException if the path is null/empty or if reading fails
     */
    public static List<String> readInputFile(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        try {
            Path path = Paths.get(filePath);
            return Files.readAllLines(path);
        } catch (InvalidPathException e) {
            throw new IllegalArgumentException("Invalid file path format: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}
