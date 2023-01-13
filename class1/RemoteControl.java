/**
 * Remote Control for a Television.
 */
public class RemoteControl {

    public static void main(String[] args) {
        Television tv = new Television();

        // Try to flip channels
        // This won't work because tv if off.
        tv.channelUp();

        // Turn on and flip the channels.
        tv.turnOn();
        tv.channelUp();
        tv.channelUp();
        tv.channelDown();

        System.out.print ("TV is now set to:  " + tv.channel);
    }
}
