package tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Bezeroa {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            String zerbitzariHelbidea = "127.0.0.1";
            int zerbitzariPortua = 12345;

            // Socketa sortu eta zerbitzariaren helbidearekin konektatu
            socket = new Socket(zerbitzariHelbidea, zerbitzariPortua);
            System.out.println("Zerbitzariari konektatzen...");

            // Bezeroarekin komunikatzeko fluxuak sortu
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Zenbaki bat bidali zerbitzariari
            int bidaltzekoZenb = 10;
            out.writeInt(bidaltzekoZenb);
            System.out.println("Zenbakia bidali: " + bidaltzekoZenb);

            // Zerbitzariaren erantzuna jaso
            int erantzuna = in.readInt();
            System.out.println("Zerbitzariaren erantzuna: " + erantzuna);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
