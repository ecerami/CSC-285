/**
 * DogPark to hold several dogs.
 */
public class DogPark {

    /**
     * Create some Dogs and Play.
     */
    public static void main(String[] args) {
        Dog dog1 = new Dog("Spot", 2);
        Dog dog2 = new Dog("Rover", 3);

        // Print out the Dogs
        System.out.println("Welcome to:  " + dog1.name);
        System.out.println("Welcome to:  " + dog2.name);

        //  Tell the dogs to do some tricks
        dog1.sit();
        dog2.rollOver();
    }
}