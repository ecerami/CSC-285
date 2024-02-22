package edu.bhcc;

/**
 * Account Class w/o Sync Support.
 */
public class AccountSync {
    private int balance = 0;

    /**
     * Gets the Current Balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposit the specified amount.
     * Note the synchronized keyword.
     * @param amount amount to add.
     */
    public synchronized void deposit (int amount) {
        int newBalance = this.balance + amount;

        // Introduce a tiny delay to magnify the problem.
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = newBalance;
    }
}
