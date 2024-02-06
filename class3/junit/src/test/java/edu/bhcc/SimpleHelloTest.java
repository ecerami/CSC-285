package edu.bhcc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for Simple Math.
 */
public class SimpleHelloTest {

    @Test
    public void testHello1() {
        String str = SimpleHello.sayHello("Ethan");
        assertEquals("Hello, Ethan!", str);
    }

    @Test
    public void testHello2() {
        String str = SimpleHello.sayHello("Ethan", "Cerami");
        assertEquals("Hello, Ethan Cerami!", str);
    }
}