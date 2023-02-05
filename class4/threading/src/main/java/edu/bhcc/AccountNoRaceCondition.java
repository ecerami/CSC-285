package edu.bhcc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Illustrates one solution to race condition.
 */
public class AccountNoRaceCondition {

    public static void main(String[] args) {
        AccountSync accountSync = new AccountSync();
        System.out.println("Account balance starts at:  " + accountSync.getBalance());

        // Create a new thread pool with new threads as needed
        ExecutorService executor = Executors.newCachedThreadPool();

        //  Launch 100 Parallel Tasks and run them in the thread pool
        for (int i=0; i<100; i++) {
            AddAPennyTaskSync task = new AddAPennyTaskSync(accountSync);
            System.out.println("Launching new task " + i);
            executor.execute(task);
        }

        //  Shutdown:  Complete all current tasks, but prevents new tasks from being added to the pool.
        executor.shutdown();

        //  Wait for all tasks to complete;  here we wait a max of 1 minute.
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //  We added 100 pennies.
        //  Does this match the account balance?
        System.out.println("Account is now:  " + accountSync.getBalance());
    }
}
