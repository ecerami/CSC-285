package edu.bhcc;

/**
 * Print Character Task.
 */
public class PrintChar implements Runnable {
    private char charToPrint;
    private int times;

    /**
     * Constructor.
     */
    public PrintChar(char charToPrint, int times) {
        this.charToPrint = charToPrint;
        this.times = times;
    }

    /**
     * Run!
     */
    public void run() {
        for (int i=0; i<this.times; i++) {
            System.out.print(this.charToPrint);
        }
    }
}
