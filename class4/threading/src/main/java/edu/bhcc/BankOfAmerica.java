package edu.bhcc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BankOfAmerica Class.
 */
public class BankOfAmerica {

    /**
     * Create an account and make deposits and withdrawals.
     */
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask(bankAccount));
        executor.execute(new WithdrawTask(bankAccount));
        executor.shutdown();
        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }
}
