package edu.bhcc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demo of Java Thread Pools.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        //  Create the Runnable Tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable printC = new PrintChar('c', 100);
        Runnable print100 = new PrintNum(100);

        //  Create a Thread Pool
        //  Try experimenting with number of threads 1..4
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //  Add Each Task to the Pool
        executor.execute(printA);
        executor.execute(printB);
        executor.execute(printC);
        executor.execute(print100);

        //  Prevent new threads from being added and wind down.
        executor.shutdown();

        //  Wait for all tasks to complete;  here we wait a max of 1 minute.
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
