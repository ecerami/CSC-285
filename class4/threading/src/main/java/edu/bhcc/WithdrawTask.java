package edu.bhcc;

/**
 * Withdraw Task.
 */
public class WithdrawTask implements Runnable {
    private BankAccount bankAccount;

    /**
     * Constructor.
     */
    public WithdrawTask(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Keep making random withdrawals.
     */
    @Override
    public void run() {
        while (true) {
            int randomAmount = (int) (Math.random() * 9) + 1;
            bankAccount.withdraw(randomAmount);
        }
    }
}
