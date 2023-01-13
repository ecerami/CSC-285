import java.util.Random;

public class RandomCircles {

    /**
     * Make Randomly Sized Circles.
     */
    public static void main(String[] args) {
        Random random = new Random(42);
        for (int i = 0; i < 10; i++) {
            double randomRadius = random.nextDouble() * 3;
            Circle circle = new Circle(randomRadius);
            double area = circle.getArea();
            System.out.printf("Radius = %f, Area = %.2f%n", randomRadius, area);
        }
    }
}