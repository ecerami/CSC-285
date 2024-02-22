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

    /**
     * Get Current Balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Withdraw a certain withdrawalAmmount.
     */
    public void withdraw(int withdrawalAmmount) {
        // Obtain the lock
        lock.lock();
        try {
            while (balance < withdrawalAmmount) {
                System.out.println("\t\t\t\tWait for: " + withdrawalAmmount);
                // Wait for the condition
                newDeposit.await();
            }
            balance -= withdrawalAmmount;
            System.out.println("\t\t\t\tWithdraw " + withdrawalAmmount + "\t\t" + getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
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
