import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Handle a Circle Request.
 */
public class HandleCircleRequest implements Runnable{
    private Socket socket;
    private DataInputStream inputFromClient;
    private DataOutputStream outputToClient;

    /**
     * Constructor.
     */
    public HandleCircleRequest(Socket socket) throws IOException {
        this.socket = socket;
        this.inputFromClient = new DataInputStream(socket.getInputStream());
        this.outputToClient = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            // Receive radius from the client
            double radius = inputFromClient.readDouble();

            // Compute area
            double area = Math.PI * radius * radius;

            // Track Progress
            System.out.println("Got radius:  " + radius);
            System.out.println("Calculated area:  " + area);

            // Send result back to client
            outputToClient.writeDouble(area);
            outputToClient.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
