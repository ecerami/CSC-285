/**
 * Model an Electric Car.
 * Used to Illustrate Inheritance.
 */
public class ElectricCar extends Car {
    private int batterySize;  // kWh battery size

    public ElectricCar (String make, String model, int year, int batterySize) {
        super(make, model, year);
        this.batterySize = batterySize;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " [" + batterySize + " kWh battery" + "]";
    }
}
