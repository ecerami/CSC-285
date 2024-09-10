import java.util.ArrayList;

/**
 * Encapsulates a Hospital with Multiple Patients.
 */
public class Hospital {

    /**
     * Main Method.
     * @param args Command Line Arguments.
     */
    public static void main(String[] args) {
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        try {
            Patient patient0 = new Patient(25);
            Patient patient1 = new Patient(-1);
            patientList.add(patient0);
            patientList.add(patient1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
}
