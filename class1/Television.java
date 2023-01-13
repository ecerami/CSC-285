/**
 * Model a Real Television with Basic Controls.
 */
public class Television {
    public int channel = 1;
    public boolean on = false;

    /**
     * Turn TV On.
     */
    public void turnOn() {
        this.on = true;
    }

    /**
     * Turn TV Off.
     */
    public void turnOff() {
        this.on = false;
    }

    /**
     * Turn Channel Up.
     */
    public void channelUp() {
        if (this.on) {
            this.channel++;
        }
    }

    /**
     * Turn Channel Down.
     */
    public void channelDown() {
        if (this.on) {
            this.channel--;
        }
    }
}
