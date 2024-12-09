import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZerbitzariaSocketTCP {
    private static final int PORT = 12345;
    private static final int MAX_ATTEMPTS = 6;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Zerbitzaria martxan dago: portua " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new HariZerbitzaria(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
