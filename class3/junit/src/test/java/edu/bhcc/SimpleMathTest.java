package edu.bhcc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Simple Math.
 */
public class SimpleMathTest {

    @Test
    public void testAddition() {
        int answer = SimpleMath.add(2, 3);
        assertEquals(5, answer);
    }

    @Test
    public void testMultiplication() {
        int answer = SimpleMath.multiply(2, 3);
        assertEquals(6, answer);
    }
}
