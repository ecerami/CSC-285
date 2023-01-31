package edu.bhcc;

public class PrintNum implements Runnable {
    private int lastNum;

    /**
     * Last Number.
     */
    public PrintNum(int lastNum) {
        this.lastNum = lastNum;
    }

    @Override
    public void run() {
        for (int i=0; i<this.lastNum; i++) {
            System.out.print(" " + i);
        }
    }
}
