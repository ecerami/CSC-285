import java.util.ArrayList;

/**
 * Used to Illustrate Aggregation.
 *
 * In aggregation, the child element can exist independently of the parent class.
 * In the code below, cars can be added and removed from each city.
 *
 */
public class City {
    private ArrayList<Car> allCars = new ArrayList<Car>();

    public void addCar(Car car) {
        this.allCars.add(car);
    }

    public Car popCar (int index) {
        Car car = this.allCars.get(index);
        this.allCars.remove(index);
        return car;
    }

    public static void main(String[] args) {
        City boston = new City();
        Car car0 = new Car("Honda", "Civic", 2020);
        Car car1 = new Car("Honda", "CRV", 2019);
        boston.addCar(car0);
        boston.addCar(car1);

        //  Move a car to a new City!
        Car car = boston.popCar(1);
        City newYork = new City();
        System.out.println(car.getDescription());
        newYork.addCar(car);
    }
}
