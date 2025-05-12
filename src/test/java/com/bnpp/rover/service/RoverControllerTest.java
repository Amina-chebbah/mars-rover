package com.bnpp.rover.service;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoverControllerTest {

    @Test
    void testProcessValidMissionFile() throws IOException {
        Path tempFile = Files.createTempFile("rover-mission", ".txt");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("5 5\n");
        writer.write("1 2 N\n");
        writer.write("LMLMLMLMM\n");
        writer.write("3 3 E\n");
        writer.write("MMRMMRMRRM\n");
        writer.close();

        RoverController controller = new RoverController();
        List<String> output = controller.processMission(tempFile.toString());

        assertEquals(2, output.size());
        assertEquals("1 3 N", output.get(0));
        assertEquals("5 1 E", output.get(1));

        Files.delete(tempFile);
    }

    @Test
    void testEmptyFileReturnsEmptyList() throws IOException {
        Path tempFile = Files.createTempFile("rover-empty", ".txt");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("");
        writer.close();

        RoverController controller = new RoverController();
        List<String> output = controller.processMission(tempFile.toString());

        assertTrue(output.isEmpty());

        Files.delete(tempFile);
    }

    @Test
    void testMissingInstructionLineSkipsRover() throws IOException {
        Path tempFile = Files.createTempFile("rover-missing-instructions", ".txt");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("5 5\n");
        writer.write("1 2 N\n");
        writer.close();

        RoverController controller = new RoverController();
        List<String> output = controller.processMission(tempFile.toString());

        assertEquals(0, output.size());

        Files.delete(tempFile);
    }

    @Test
    void testInvalidPlateauLineReturnsEmpty() throws IOException {
        Path tempFile = Files.createTempFile("rover-invalid-plateau", ".txt");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("invalid line\n");
        writer.write("1 2 N\n");
        writer.write("LMLMLMLMM\n");
        writer.close();

        RoverController controller = new RoverController();
        List<String> output = controller.processMission(tempFile.toString());

        assertTrue(output.isEmpty());

        Files.delete(tempFile);
    }

    @Test
    void testInvalidInstructionSkipsRover() throws IOException {
        Path tempFile = Files.createTempFile("rover-invalid-instruction", ".txt");
        FileWriter writer = new FileWriter(tempFile.toFile());
        writer.write("5 5\n");
        writer.write("1 2 N\n");
        writer.write("LMLXM\n");
        writer.close();

        RoverController controller = new RoverController();
        List<String> output = controller.processMission(tempFile.toString());

        assertTrue(output.isEmpty());

        Files.delete(tempFile);
    }

}
