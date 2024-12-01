import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Bezeroa {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        BufferedReader userInput = null;

        try {
            String zerbitzariHelbidea = "127.0.0.1";
            int zerbitzariPortua = 12345;

            // Socketa sortu eta zerbitzariaren helbidearekin konektatu
            socket = new Socket(zerbitzariHelbidea, zerbitzariPortua);
            System.out.println("Zerbitzarira konektatzen...");

            // Bezeroarekin komunikatzeko fluxuak sortu
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            userInput = new BufferedReader(new InputStreamReader(System.in));

            // Zerbitzariaren mezua jaso
            String zerbitzariMezua = in.readUTF();
            System.out.println(zerbitzariMezua);

            // Erabiltzaileari izena eta adina eskatu
            System.out.print("Idatzi zure izena eta adina (adibidez: Jon 17): ");
            String inputData = userInput.readLine();

            // Zerbitzariari datuak bidali
            out.writeUTF(inputData);

            // Zerbitzariaren erantzuna jaso
            String erantzuna = in.readUTF();
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
