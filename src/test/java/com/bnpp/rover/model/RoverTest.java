package com.bnpp.rover.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void testInitialPositionAndDirection() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.NORTH, plateau);
        assertEquals(1, rover.getX());
        assertEquals(2, rover.getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    void testRotateLeft() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(0, 0, Direction.NORTH, plateau);
        rover.turnLeft();
        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    void testRotateRight() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(0, 0, Direction.NORTH, plateau);
        rover.turnRight();
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @Test
    void testMoveForwardWithinBounds() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.NORTH, plateau);
        rover.moveForward();
        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
    }

    @Test
    void testMoveForwardOutOfBounds() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(0, 5, Direction.NORTH, plateau);
        rover.moveForward();
        assertEquals(0, rover.getX());
        assertEquals(5, rover.getY());
    }

    @Test
    void testProcessInstructions() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, Direction.NORTH, plateau);
        rover.processInstructions("LMLMLMLMM");
        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }
}
