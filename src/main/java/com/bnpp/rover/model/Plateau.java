package com.bnpp.rover.model;

import lombok.Getter;

/**
 * Represents the plateau on Mars where rovers operate.
 * The plateau is a 2D grid defined by its maximum X and Y boundaries.
 */
@Getter
public class Plateau {
    private final int maxX;
    private final int maxY;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    /**
     * Constructs a Plateau with upper-right boundaries.
     * @param maxX maximum X coordinate (inclusive)
     * @param maxY maximum Y coordinate (inclusive)
     * @throws IllegalArgumentException if maxX or maxY is negative
     */
    public Plateau(int maxX, int maxY) {
        if (maxX < 0 || maxY < 0) {
            throw new IllegalArgumentException("Plateau dimensions must be non-negative. Received: maxX=" + maxX + ", maxY=" + maxY);
        }
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Checks if the given coordinates are within the plateau boundaries.
     * @param x X coordinate to check
     * @param y Y coordinate to check
     * @return true if (x, y) is within bounds, false otherwise
     */
    public boolean isWithinBounds(int x, int y) {
        return x >= MIN_X && x <= maxX && y >= MIN_Y && y <= maxY;
    }
}
