package com.bnpp.rover.service;

import com.bnpp.rover.model.Plateau;
import com.bnpp.rover.model.Rover;
import com.bnpp.rover.util.FileReaderUtil;

import java.util.List;

public class RoverController {

    public void processInput(String path) {
        List<String> lines = FileReaderUtil.readInputFile(path);
        Plateau plateau = parsePlateau(lines.getFirst());

        for (int i = 1; i < lines.size(); i+=2) {
            Rover rover = parseRoverPosition(lines.get(i));
            String commands = lines.get(i+1);
            executeCommands(rover, commands, plateau);
            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection());
        }
    }

    private Plateau parsePlateau(String line) {
        String[] parts = line.split(" ");
        return new Plateau(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    private Rover parseRoverPosition(String line) {
        String[] parts = line.split(" ");
        return new Rover(Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                parts[2].charAt(0));
    }

    private void executeCommands(Rover rover, String commands, Plateau plateau) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> rover.rotateLeft();
                case 'R' -> rover.rotateRight();
                case 'M' -> {
                    rover.moveForward();
                    if (rover.getX() > plateau.getMaxX()) rover.setX(plateau.getMaxX());
                    if (rover.getY() > plateau.getMaxY()) rover.setY(plateau.getMaxY());
                    if (rover.getX() < 0) rover.setX(0);
                    if (rover.getY() < 0) rover.setY(0);
                }
            }
        }
    }
}
