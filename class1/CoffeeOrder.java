/**
 * Model a Coffee Order.
 */
public class CoffeeOrder {
    public CoffeeSize coffeeSize;
    public CoffeeType coffeeType;

    // Static Variable to Track Total Number of Orders/Objects.
    public static int numOrders = 0;

    public CoffeeOrder(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
        CoffeeOrder.numOrders++;
    }
}

/**
 * Enumerated Coffee Sizes.
 */
enum CoffeeSize {
    SMALL, MEDIUM, LARGE
}

/**
 * Enumerated Coffee Types.
 */
enum CoffeeType {
    AMERICANO, ESPRESSO, LATTE
}