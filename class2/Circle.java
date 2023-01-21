/**
 * Circle Class.
 */
public class Circle {
    public double radius = 1;

    /**
     * Constructor.
     * @param radius Radius.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Get Area:  PI(r)^2
     * @return Area of the Circle.
     */
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}