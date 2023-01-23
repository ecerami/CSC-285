/**
 * Person class.
 * Used to illustrate composition.
 * In the case of composition, a child element cannot exist independently of the parent class.
 *
 * In this case, our two hands and heart are defined as composition, because they are:
 * 1.  declared as private, and
 * 2.  are also not accessible via any getters.
 *
*/
public class Person {
    private Hand leftHand = new Hand();
    private Hand rightHand = new Hand();
    private Heart heart = new Heart();

    public void describe() {
        System.out.println("This is a person with:  ");
        System.out.println(leftHand.toString());
        System.out.println(rightHand.toString());
        System.out.println(heart.toString());
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.describe();
    }
}
