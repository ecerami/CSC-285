/**
 * Animal Used to Illustrate UML.
 */
public class Animal {
    public String speciesName;
    public String commonName;

    public Animal(String speciesName, String commonName) {
        this.speciesName = speciesName;
        this.commonName = commonName;
    }

    public void move() {
        System.out.println("The Animal Moved!");
    }

    public void makeSound() {
        System.out.println("The Animal Made a Sound!");
    }
}
