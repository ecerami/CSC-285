import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Circle Server.
 */
public class CircleServerMulti {

    /**
     * Run Multithreaded Server.
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server at:  " + new Date());
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            // Wait for new connection
            Socket socket = serverSocket.accept();

            //  Spawn new thread for every new connection
            HandleCircleRequest circleRequest = new HandleCircleRequest(socket);
            Thread thread = new Thread(circleRequest);
            thread.start();
        }
    }
}