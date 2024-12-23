package edu.bhcc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the Human Class.
 */
class HumanTest {
    private Human frodo;

    @BeforeEach
    public void setup(){
        this.frodo = new Human("Frodo", 200);
    }

    @Test
    public void testHuman() {
        assertEquals("Frodo", this.frodo.getName());
        assertEquals(200, this.frodo.getNumHitPoints());
    }

    @Test
    public void humanTakesDamage() {
        this.frodo.takeDamage(100);
        assertEquals(100, this.frodo.getNumHitPoints());
    }

}