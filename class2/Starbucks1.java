/**
 * Simulate a Starbucks with Multiple Coffee Orders.
 */
public class Starbucks1 {

    public static void main(String[] args) {
        System.out.println("Opening Starbucks");
        printNumOrders();

        CoffeeOrder order0 = new CoffeeOrder("Large", "Latte");
        CoffeeOrder order1 = new CoffeeOrder("Medium", "Espresso");
        printNumOrders();
    }

    /**
     * Example of a static method.
     */
    public static void printNumOrders() {
        //  Here we are referencing a static variable.
        System.out.println("Total number of orders so far:  " + CoffeeOrder.numOrders);
    }
}
