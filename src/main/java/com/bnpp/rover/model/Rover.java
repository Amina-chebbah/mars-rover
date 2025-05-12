package com.bnpp.rover.model;

import lombok.Getter;

/**
 * Represents a rover exploring the Mars plateau.
 */
@Getter
public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private final Plateau plateau;

    /**
     * Constructs a new Rover.
     * @param x         Initial X coordinate
     * @param y         Initial Y coordinate
     * @param direction Initial direction (NORTH, EAST, SOUTH, WEST)
     * @param plateau   The plateau on which the rover operates
     */
    public Rover(int x, int y, Direction direction, Plateau plateau) {
        if (plateau == null) {
            throw new IllegalArgumentException("Plateau cannot be null.");
        }
        if (!plateau.isWithinBounds(x, y)) {
            throw new IllegalArgumentException(
                    String.format("Initial Rover position (%d, %d) is outside plateau boundaries (0-%d, 0-%d).",
                            x, y, plateau.getMaxX(), plateau.getMaxY()));
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.plateau = plateau;
    }

    /**
     * Rotates the rover 90 degrees to the left.
     */
    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    /**
     * Rotates the rover 90 degrees to the right.
     */
    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    /**
     * Moves the rover forward by one grid cell in its current direction,
     * only if the target cell is within the plateau boundaries.
     */
    public void moveForward() {
        int nextX = this.x;
        int nextY = this.y;

        switch (this.direction) {
            case NORTH -> nextY++;
            case EAST  -> nextX++;
            case SOUTH -> nextY--;
            case WEST  -> nextX--;
        }

        if (this.plateau.isWithinBounds(nextX, nextY)) {
            this.x = nextX;
            this.y = nextY;
        }
    }

    /**
     * Executes a sequence of movement instructions: L, R, M.
     * @param instructions The instruction string (e.g. "LMLMLM")
     * @throws IllegalArgumentException if an unknown instruction is found
     */
    public void processInstructions(String instructions) {
        if (instructions == null) {
            throw new IllegalArgumentException("Instructions string cannot be null.");
        }

        for (char instruction : instructions.toCharArray()) {
            switch (Character.toUpperCase(instruction)) {
                case 'L' -> turnLeft();
                case 'R' -> turnRight();
                case 'M' -> moveForward();
                default -> throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }

    /**
     * Returns a string representation of the rover’s current state.
     * @return current position and direction (e.g. "1 3 N")
     */
    @Override
    public String toString() {
        return x + " " + y + " " + direction.getShortName();
    }
}