import java.io.Serializable;

/**
 * Serializable Student Class.
 */
public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String zip;

    /**
     * Default Constructor.
     */
    public Student(String firstName, String lastName, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
