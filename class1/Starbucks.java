/**
 * Simulate a Starbucks with Multiple Coffee Orders.
 */
public class Starbucks {

    public static void main(String[] args) {
        System.out.println("Opening Starbucks");
        printNumOrders();

        CoffeeOrder order0 = new CoffeeOrder(CoffeeSize.LARGE, CoffeeType.LATTE);
        CoffeeOrder order1 = new CoffeeOrder(CoffeeSize.MEDIUM, CoffeeType.ESPRESSO);
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
