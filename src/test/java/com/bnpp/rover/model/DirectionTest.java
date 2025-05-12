package com.bnpp.rover.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void testTurnLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
    }

    @Test
    void testTurnRight() {
        assertEquals(Direction.EAST, Direction.NORTH.turnRight());
        assertEquals(Direction.NORTH, Direction.WEST.turnRight());
    }

    @Test
    void testFromChar() {
        assertEquals(Direction.NORTH, Direction.fromChar('N'));
        assertThrows(IllegalArgumentException.class, () -> Direction.fromChar('X'));
    }
}
