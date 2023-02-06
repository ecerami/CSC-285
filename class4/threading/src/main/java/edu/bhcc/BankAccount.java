package edu.bhcc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank Account with Locks and Conditions.
 */
public class BankAccount {
    private int balance;
    private Lock lock = new ReentrantLock();
    private Condition newDeposit = lock.newCondition();

    public int getBalance() {
        return balance;
    }

    /**
     * Withdraw a certain amount.
     */
    public void withdraw(int amount) {
        // Obtain the lock
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println("\t\t\t\tWait for: " + amount);
                // Wait for the condition
                newDeposit.await();
            }
            balance -= amount;
            System.out.println("\t\t\t\tWithdraw " + amount + "\t\t" + getBalance());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Make a deposit.
     */
    public void deposit(int amount) {
        lock.lock();
        balance += amount;
        System.out.println("Deposit:  " + amount + "\t\t\t\t\t\t" + getBalance());

        // Signal any threads waiting on this condition
        newDeposit.signalAll();
        lock.unlock();
    }
}
