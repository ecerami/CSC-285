package edu.bhcc;

/**
 * Print Numbers Task.
 */
public class PrintNum implements Runnable {
    private int lastNum;

    /**
     * Constructor.
      * @param lastNum Print 0..lastNum.
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
