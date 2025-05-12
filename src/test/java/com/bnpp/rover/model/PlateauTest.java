package com.bnpp.rover.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testValidPlateau() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue(plateau.isWithinBounds(0, 0));
        assertTrue(plateau.isWithinBounds(5, 5));
        assertFalse(plateau.isWithinBounds(6, 5));
        assertFalse(plateau.isWithinBounds(5, 6));
    }

    @Test
    void testNegativePlateauThrows() {
        assertThrows(IllegalArgumentException.class, () -> new Plateau(-1, 5));
    }
}
