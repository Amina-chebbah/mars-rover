package com.bnpp.rover.service;

import com.bnpp.rover.model.Direction;
import com.bnpp.rover.model.Plateau;
import com.bnpp.rover.model.Rover;
import com.bnpp.rover.util.FileReaderUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoverController {

    /**
     * Exécute la mission en lisant les instructions depuis un fichier.
     * @param inputFilePath chemin du fichier d’entrée
     * @return liste des positions finales de chaque rover
     */
    public List<String> processMission(String inputFilePath) {
        List<String> finalRoverStates = new ArrayList<>();
        List<String> lines;

        try {
            lines = FileReaderUtil.readInputFile(inputFilePath);
        } catch (RuntimeException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return Collections.emptyList();
        }

        if (lines.isEmpty()) {
            System.err.println("Input file is empty or invalid.");
            return Collections.emptyList();
        }

        Plateau plateau;
        try {
            plateau = parsePlateau(lines.getFirst());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid plateau configuration: " + e.getMessage());
            return Collections.emptyList();
        }

        for (int i = 1; i < lines.size(); i += 2) {
            if (i + 1 >= lines.size()) {
                System.err.println("Missing instruction line for rover at line " + (i + 1));
                continue;
            }

            String positionLine = lines.get(i);
            String instructionsLine = lines.get(i + 1);

            try {
                Rover rover = parseRover(positionLine, plateau);
                rover.processInstructions(instructionsLine);
                finalRoverStates.add(rover.toString());
            } catch (IllegalArgumentException e) {
                System.err.println("Error processing rover: " + e.getMessage());
            }
        }

        return finalRoverStates;
    }

    private Plateau parsePlateau(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Expected 2 integers for plateau dimensions.");
        }

        int maxX = Integer.parseInt(parts[0]);
        int maxY = Integer.parseInt(parts[1]);
        return new Plateau(maxX, maxY);
    }

    private Rover parseRover(String line, Plateau plateau) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Expected 2 integers and 1 character for rover position.");
        }

        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        Direction direction = Direction.fromChar(parts[2].charAt(0));

        return new Rover(x, y, direction, plateau);
    }
}
