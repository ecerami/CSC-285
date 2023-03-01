import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A Very Simple Server.
 * Accepts One Connection, Returns a Result and Ends.
 */
public class CircleServerSimple {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server at:  " + new Date());

        //  Start Server
        ServerSocket serverSocket = new ServerSocket(8000);

        // Wait for Client Connection
        Socket socket = serverSocket.accept();
        InetAddress inetAddress = socket.getInetAddress();
        System.out.println("Got client request from:  " + inetAddress.getHostAddress());

        //  Set up the In/Out Streams
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

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

        //  Stop everything
        socket.close();
        serverSocket.close();
        System.out.println("Stopping server at:  " + new Date());
    }
}
