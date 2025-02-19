package edu.bhcc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Simple Hello.
 */
public class SimpleHelloTest {

    @Test
    public void testHello1() {
        SimpleHello hello = new SimpleHello();
        String str = hello.sayHello("Ethan");
        assertEquals("Hello, Ethan!", str);
    }

    @Test
    public void testHello2() {
        SimpleHello hello = new SimpleHello();
        String str = hello.sayHello("Ethan", "Cerami");
        assertEquals("Hello, Ethan Cerami!", str);
    }
}