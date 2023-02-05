package edu.bhcc;

public class AddAPennyTaskNoSync implements Runnable {
    private AccountNoSync accountNoSync;

    /**
     * Constructor with Account Object.
     */
    public AddAPennyTaskNoSync(AccountNoSync accountNoSync) {
        this.accountNoSync = accountNoSync;
    }

    @Override
    public void run() {
        System.out.println("Adding one penny.");
        this.accountNoSync.deposit(1);
    }
}
