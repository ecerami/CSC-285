package edu.bhcc;

/**
 * Simple Hello Class.
 */
public class SimpleHello {

    /**
     * Say Hello.
     *
     * @param firstName User's First Name.
     * @return Hello Message.
     */
    public String sayHello(String firstName) {
        return "Hello, " + firstName + "!";
    }

    /**
     * Say Hello.
     *
     * @param firstName User's First Name.
     * @param lastName  User's Last Name.
     * @return Hello Message.
     */
    public String sayHello(String firstName, String lastName) {
        return "Hello, " + firstName + " " + lastName + "!";
    }
}
