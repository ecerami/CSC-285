import java.util.ArrayList;

public class Starbucks2 {

    public static void main(String[] args) {
        System.out.println("Opening Starbucks");

        //  Create ArrayList of Coffee Orders
        ArrayList<CoffeeOrder> orderList = new ArrayList<CoffeeOrder>();

        // Create 10 Orders
        for (int i=0; i<10; i++) {
            CoffeeOrder order = new CoffeeOrder("Large", "Cappuccino");
            orderList.add(order);
        }

        // Print all the Orders
        for (CoffeeOrder order:  orderList) {
            System.out.println(order.coffeeSize + " " + order.coffeeType);
        }
    }

}
