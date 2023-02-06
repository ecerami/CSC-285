package edu.bhcc;

/**
 * Deposit Task.
 */
public class DepositTask implements Runnable {
    private BankAccount bankAccount;

    public DepositTask(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Deposit a random amount every 1 second.
     */
    @Override
    public void run() {
        while (true) {
            int randomAmount = (int)(Math.random() * 10) + 1;
            this.bankAccount.deposit(randomAmount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
