import java.io.*;
import java.net.Socket;

/**
 * Handle a Student Request.
 */
public class HandleStudentRequest implements Runnable{
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private BufferedWriter bufferedOutputWriter;

    /**
     * Constructor.
     */
    public HandleStudentRequest(Socket socket) throws IOException {
        this.socket = socket;
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        this.bufferedOutputWriter = new BufferedWriter(outputStreamWriter);
    }

    @Override
    public void run() {
        try {
            // Receive student from the client
            Student student = (Student) this.objectInputStream.readObject();

            // Output Student Info
            System.out.println("First Name:  " + student.getFirstName());
            System.out.println("Last Name:  " + student.getLastName());
            System.out.println("City:  " + student.getCity());
            System.out.println("State:  " + student.getState());
            System.out.println("Zip:  " + student.getZip());

            // Send OK Response back to client
            this.bufferedOutputWriter.write("OK");
            this.bufferedOutputWriter.flush();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}