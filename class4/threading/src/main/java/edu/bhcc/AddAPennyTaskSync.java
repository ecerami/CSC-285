package edu.bhcc;

public class AddAPennyTaskSync implements Runnable {
    private AccountSync accountSync;

    /**
     * Constructor with Account Object.
     */
    public AddAPennyTaskSync(AccountSync accountSync) {
        this.accountSync = accountSync;
    }

    @Override
    public void run() {
        System.out.println("Adding one penny.");
        this.accountSync.deposit(1);
    }
}
