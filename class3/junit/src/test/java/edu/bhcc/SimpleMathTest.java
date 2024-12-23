package edu.bhcc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Simple Math.
 */
public class SimpleMathTest {
    private int num1;
    private int num2;

    @BeforeEach
    public void setup() {
        this.num1 = 2;
        this.num2 = 3;
    }

    @Test
    public void testAddition() {
        SimpleMath math = new SimpleMath();
        int answer = math.add(num1, num2);
        assertEquals(5, answer);
    }

    @Test
    public void testMultiplication() {
        SimpleMath math = new SimpleMath();
        int answer = math.multiply(num1, num2);
        assertEquals(6, answer);
    }
}
