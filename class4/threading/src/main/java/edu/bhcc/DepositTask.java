package edu.bhcc;

/**
 * Deposit Task.
 */
public class DepositTask implements Runnable {
    private BankAccount bankAccount;

    /**
     * Constructor.
     */
    public DepositTask(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Deposit a random amount every 1 second.
     */
    @Override
    public void run() {
        while (true) {
            int randomAmount = (int)(Math.random() * 9) + 1;
            this.bankAccount.deposit(randomAmount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
