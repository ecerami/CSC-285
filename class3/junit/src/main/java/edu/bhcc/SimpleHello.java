package edu.bhcc;

/**
 * Simple Hello Class.
 */
public class SimpleHello {

    /**
     * Say Hello!
     */
    static public String sayHello(String firstName) {
        return "Hello, " + firstName + "!";
    }

    /**
     * Say Hello!
     */
    static public String sayHello(String firstName, String lastName) {
        return "Hello, " + firstName + " " + lastName + "!";
    }
}
