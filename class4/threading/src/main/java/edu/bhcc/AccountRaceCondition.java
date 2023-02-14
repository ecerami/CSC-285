package edu.bhcc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Illustrates race conditions in multithreaded applications.
 */
public class AccountRaceCondition {

    public static void main(String[] args) {
        AccountNoSync account = new AccountNoSync();
        System.out.println("Account balance starts at:  " + account.getBalance());

        // Create a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(100);

        //  Launch 100 Parallel Tasks and run them in the thread pool
        for (int i=0; i<100; i++) {
            AddAPennyTaskNoSync task = new AddAPennyTaskNoSync(account);
            System.out.println("Launching new task " + i);
            executor.execute(task);
        }

        //  Shutdown:  Complete all current tasks, but prevents new tasks from being added to the pool.
        executor.shutdown();

        //  Wait for all tasks to complete;  here we wait a max of 1 minute.
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  We tried to add 100 pennies.
        //  Does this match the account balance?
        System.out.println("Account is now:  " + account.getBalance());
    }

}
