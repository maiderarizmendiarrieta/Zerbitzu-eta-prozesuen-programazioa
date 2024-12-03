package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Zerbitzaria {
    public static void main(String[] args) {
        ServerSocket zerbitzariSocket = null;
        Socket bezeroSocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            int portua = 12345;
            zerbitzariSocket = new ServerSocket(portua);
            System.out.println("TCP Zerbitzaria martxan " + portua + " portuan");

            // Bezeroaren konexioa onartu
            bezeroSocket = zerbitzariSocket.accept();
            System.out.println("Bezeroa konektatuta: " + bezeroSocket.getInetAddress());

            // Bezeroarekin komunikatzeko fluxuak sortu
            in = new DataInputStream(bezeroSocket.getInputStream());
            out = new DataOutputStream(bezeroSocket.getOutputStream());

            // Bezeroak bidalitako zenbakia jaso
            int bezeroZenbakia = in.readInt();
            System.out.println("Bezeroak bidalitako zenbakia: " + bezeroZenbakia);

            // Ausazko zenbaki bat sortu
            Random random = new Random();
            int n = random.nextInt(100); // 0 - 99 bitartekoa
            System.out.println("Ausazko zenbakia sortu da: " + n);

            // Erantzuna bidali (bezeroari zenbakia eta ausazko zenbakia batuta)
            int result = bezeroZenbakia + n;
            out.writeInt(result);
            System.out.println("Erantzuna bidali: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if (bezeroSocket != null)
                    bezeroSocket.close();
                if (zerbitzariSocket != null)
                    zerbitzariSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}