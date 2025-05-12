package com.bnpp.rover.model;

import lombok.Getter;

/**
 * Enum representing the four cardinal directions for the Rover.
 * Each direction knows how to turn left or right.
 */
@Getter
public enum Direction {
    NORTH("N") {
        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },
    EAST("E") {
        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }
    },
    SOUTH("S") {
        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }
    },
    WEST("W") {
        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }
    };

    private final String shortName;

    Direction(String shortName) {
        this.shortName = shortName;
    }

    public abstract Direction turnLeft();
    public abstract Direction turnRight();

    /**
     * Converts a character to the corresponding Direction enum.
     * @param directionChar The character representing the direction (N, E, S, W)
     * @return Direction enum
     * @throws IllegalArgumentException if the input is invalid
     */
    public static Direction fromChar(char directionChar) {
        return switch (Character.toUpperCase(directionChar)) {
            case 'N' -> NORTH;
            case 'E' -> EAST;
            case 'S' -> SOUTH;
            case 'W' -> WEST;
            default -> throw new IllegalArgumentException("Invalid direction character: " + directionChar);
        };
    }
}