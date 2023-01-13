/**
 * A Drawing of Basic Shapes.
 */
public class Drawing {

    /**
     * Create a Drawing with Two Circles.
     */
    public static void main(String[] args) {
        Circle circle0 = new Circle(3);
        Circle circle1 = new Circle(3.4);

        double area0 = circle0.getArea();
        double area1 = circle1.getArea();

        System.out.printf("Area of circle 0:  %.2f%n", area0);
        System.out.printf("Area of circle 1:  %.2f%n", area1);
    }
}
