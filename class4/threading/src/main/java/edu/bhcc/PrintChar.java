package edu.bhcc;

/**
 * Hello world!
 *
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

    @Override
    public void run() {
        for (int i=0; i<this.times; i++) {
            System.out.print(this.charToPrint);
        }
    }
}
