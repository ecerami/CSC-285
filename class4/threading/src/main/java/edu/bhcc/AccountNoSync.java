package edu.bhcc;

/**
 * Account Class w/o Sync Support.
 * This class is *not* thread safe.
 */
public class AccountNoSync {
    private int balance = 0;

    /**
     * Gets the Current Balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposit the specified amount.
     * @param amount amount to add.
     */
    public void deposit (int amount) {
        int newBalance = this.balance + amount;

        // Introduce a tiny delay to magnify the problem.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = newBalance;
    }
}
