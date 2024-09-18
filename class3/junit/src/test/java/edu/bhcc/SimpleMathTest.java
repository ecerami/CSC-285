package edu.bhcc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Simple Math.
 */
public class SimpleMathTest {

    @Test
    public void testAddition() {
        SimpleMath math = new SimpleMath();
        int answer = math.add(2, 3);
        assertEquals(5, answer);
    }

    @Test
    public void testMultiplication() {
        SimpleMath math = new SimpleMath();
        int answer = math.multiply(2, 3);
        assertEquals(6, answer);
    }
}
