/**
 * Model a Nuclear Power Plant.
 * Used to Illustrate Importance of Data Encapsulation and Access Modifiers.
 */
public class NuclearPowerPlant {
    private boolean running = true;

    /**
     * Enforce Power Down Sequence.
     */
    public void powerDown() {
        System.out.println("Initiating Shutdown Sequence");
        this.flushWaterSystems();
        this.disableNuclearCore();
        this.running = false;
        System.out.println("Nuclear Power Plant is now off");
    }

    /**
     * Accessor Method.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Example Private Method.
     */
    private void flushWaterSystems() {
        System.out.println("Flushing Water Systems");
    }

    /**
     * Example Private Method.
     */
    private void disableNuclearCore() {
        System.out.println("Disabling Nuclear Core");
    }
}
