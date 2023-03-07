import java.io.*;
import java.net.Socket;

/**
 * Student Client.
 */
public class StudentClient {

    public static void main(String[] args) throws IOException {
        //  Create a Fake Student
        Student student = new Student
            ("John", "Doe", "Springfield", "MA", "01103");

        //  Send Serialized Student over the Wire
        Socket socket = new Socket("localhost", 8000);
        System.out.println("Sending student:  " + student.getLastName());

        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        toServer.writeObject(student);
        toServer.flush();

        //  Get Server Response
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String response = reader.readLine();
        System.out.println("Got response:  " + response);
        socket.close();
    }
}
