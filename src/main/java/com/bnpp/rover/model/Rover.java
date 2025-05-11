package com.bnpp.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rover {
    private int x;
    private int y;
    private char direction;

    public void moveForward() {
        switch (direction) {
            case 'N' -> y++;
            case 'S' -> y--;
            case 'E' -> x++;
            case 'W' -> x--;
        }
    }

    public void rotateLeft() {
       direction = switch (direction) {
           case 'N' -> 'W';
           case 'W' -> 'S';
           case 'S' -> 'E';
           case 'E' -> 'N';
           default -> direction;
       };
    }

    public void rotateRight() {
        direction = switch (direction) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> direction;
        };
    }
}
