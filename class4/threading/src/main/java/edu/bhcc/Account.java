package edu.bhcc;

/**
 * Account Class.
 */
public class Account {
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

        // Introduce a delay to magnify the problem.
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
