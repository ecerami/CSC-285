/**
 * Models a Patient and their Clinical Data.
 */
public class Patient {
    private int age;

    /**
     * Constructor.
     *
     * @param age current age of patient.
     */
    public Patient(int age) {
        this.setAge(age);
    }

    /**
     * Set Patient Age.
     *
     * @param age current age.
     */
    public void setAge(int age) {
        if (age < 0 || age > 125) {
            throw new IllegalArgumentException("Age must be between 0 and 125")
        } else {
            this.age = age;
        }
    }
}
