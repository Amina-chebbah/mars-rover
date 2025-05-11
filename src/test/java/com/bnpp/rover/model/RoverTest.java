package com.bnpp.rover.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void testRotateAndMove() {
        Rover rover = new Rover(1, 2, 'N');
        rover.rotateLeft(); // W
        rover.moveForward(); // x--
        rover.rotateRight(); // N
        rover.moveForward(); // y++

        assertEquals(0, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals('N', rover.getDirection());

    }
}
