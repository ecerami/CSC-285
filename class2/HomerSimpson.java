/**
 * Model Shutdown of Nuclear Power Plant.
 */
public class HomerSimpson {

    public static void main(String[] args) {
        NuclearPowerPlant powerPlant = new NuclearPowerPlant();
        System.out.println("Power Plant is Running?  " + powerPlant.isRunning());
        powerPlant.powerDown();
    }
}
