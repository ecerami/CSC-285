package edu.bhcc;

public class AddAPennyTask implements Runnable {
    private Account account;

    /**
     * Constructor with Account Object.
     */
    public AddAPennyTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        System.out.println("Adding one penny.");
        this.account.deposit(1);
    }
}
