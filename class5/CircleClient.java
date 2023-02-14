import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Circle Client.
 */
public class CircleClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);

        //  Get radius from command line
        double radius = Double.parseDouble(args[0]);

        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        System.out.println("Sending radius:  " + radius);
        toServer.writeDouble(radius);
        toServer.flush();
        double area = fromServer.readDouble();
        System.out.println("Received area:  " + area);
        socket.close();
    }
}
