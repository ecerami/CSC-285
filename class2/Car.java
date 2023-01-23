/**
 * Model a Basic Car.
 */
public class Car {
    protected String make;
    protected String model;
    protected int year;

    public Car (String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getDescription() {
        return this.make + " " + this.model + " [" + year + "]";
    }
}
