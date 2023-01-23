/**
 * Used Car Sales Site.
 */
public class CarMax {

    public static void main(String[] args) {
        Car car0 = new Car("Toyota", "Camry", 2020);
        Car car1 = new ElectricCar("Tesla", "Model 3", 2021, 82);
        System.out.println(car0.getDescription());
        System.out.println(car1.getDescription());
    }
}
