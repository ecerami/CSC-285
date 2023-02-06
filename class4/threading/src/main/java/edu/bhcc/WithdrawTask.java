package edu.bhcc;

public class WithdrawTask implements Runnable {
    private BankAccount bankAccount;

    public WithdrawTask(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * Keep making random withdrawals.
     */
    @Override
    public void run() {
        while (true) {
            int randomAmount = (int) (Math.random() * 10) + 1;
            bankAccount.withdraw(randomAmount);
        }
    }
}
