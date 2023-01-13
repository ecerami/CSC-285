/**
 * Model of a real Dog.
 */
public class Dog {
    public String name;
    public int age;

    /**
     * Constructor.
     * @param name Dog Name.
     * @param age Dog Age.
     */
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Tell the Dog to Sit!
     */
    public void sit() {
        System.out.println(this.name + " is now sitting!");
    }

    /**
     * Tell the Dog to Roll-Over!
     */
    public void rollOver() {
        System.out.println(this.name + " just rolled over!");
    }
}