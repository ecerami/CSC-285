package edu.bhcc;

/**
 * Demo of Tasks.
 */
public class TaskThreadDemo {

    public static void main(String[] args) {
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        Thread thread0 = new Thread(printA);
        Thread thread1 = new Thread(printB);
        Thread thread2 = new Thread(print100);

        thread0.start();
        thread1.start();
        thread2.start();
    }
}
