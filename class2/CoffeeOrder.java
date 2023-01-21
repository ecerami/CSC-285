/**
 * Model a Coffee Order.
 */
public class CoffeeOrder {
    public String coffeeSize;
    public String coffeeType;

    // Static Variable to Track Total Number of Orders/Objects.
    public static int numOrders = 0;

    public CoffeeOrder(String coffeeSize, String coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
        CoffeeOrder.numOrders++;
    }
}

