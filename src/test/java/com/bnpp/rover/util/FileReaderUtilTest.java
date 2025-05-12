package com.bnpp.rover.util;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderUtilTest {

    @Test
    void testReadValidFile() throws IOException {
        Path tempFile = Files.createTempFile("test-file", ".txt");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("5 5\n1 2 N\nLMLMLMLMM\n");
        writer.close();

        List<String> lines = FileReaderUtil.readInputFile(tempFile.toString());
        assertEquals(3, lines.size());
        Files.delete(tempFile);
    }

    @Test
    void testNullPathThrows() {
        assertThrows(IllegalArgumentException.class, () -> FileReaderUtil.readInputFile(null));
    }

    @Test
    void testEmptyPathThrows() {
        assertThrows(IllegalArgumentException.class, () -> FileReaderUtil.readInputFile("   "));
    }

    @Test
    void testInvalidPathThrows() {
        assertThrows(RuntimeException.class, () -> FileReaderUtil.readInputFile("Z:/invalid//path?.txt"));
    }

    @Test
    void testNonExistentFileThrows() {
        assertThrows(RuntimeException.class, () -> FileReaderUtil.readInputFile("non_existent_input.txt"));
    }
}
