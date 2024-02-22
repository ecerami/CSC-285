package edu.bhcc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demo of Java Thread Pools.
 */
public class ThreadPoolDemo {

    /**
     * Create a Fixed Thread Pool for All Worker Threads.
     */
    public static void main(String[] args) {
        //  Create a Thread Pool
        //  Try experimenting with number of threads 1..4
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //  Add Each Task to the Pool
        for (int i = 0; i < 1000; i++) {
            Runnable print100 = new PrintNum(100);
            executor.execute(print100);
        }
        //  Prevent new threads from being added and wind down.
        executor.shutdown();

        //  Wait for all tasks to complete;  here we wait a max of 1 minute.
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
