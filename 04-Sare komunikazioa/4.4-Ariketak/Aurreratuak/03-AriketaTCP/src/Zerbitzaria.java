import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Zerbitzaria {
    public static void main(String[] args) {
        ServerSocket zerbitzariSocket = null;
        Socket bezeroSocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            int portua = 12345;
            zerbitzariSocket = new ServerSocket(portua);

            // Bezeroaren konexioa onartu
            bezeroSocket = zerbitzariSocket.accept();
            System.out.println("Bezeroa konektatuta: " + bezeroSocket.getInetAddress());

            // Bezeroarekin komunnikatzeko fluxuak sortu
            in = new DataInputStream(bezeroSocket.getInputStream());
            out = new DataOutputStream(bezeroSocket.getOutputStream());

            // Bezeroari mezua bidali
            out.writeUTF("Maider 19");

            // Bezeroak bidalitako izena eta adina jaso
            String data = in.readUTF();
            System.out.println("Bezeroaren mezua jasota: " + data);
            
            // Izena eta adina banatu
            try {
                String[] parts = data.split(" ");
                String izena = parts[0];
                int adina = Integer.parseInt(parts[1]);

                // Adingabea den ala ez aztertu
                String erantzuna;
                if (adina < 18) {
                    erantzuna = izena + " " + adina + " urte ditu, adingabea da.";
                } else {
                    erantzuna = izena + " " + adina + " urte ditu, adingabea ez da.";
                }

                // Erantzuna bidali
                out.writeUTF(erantzuna);

            } catch (Exception e) {
                out.writeUTF("Errore bat gertatu da. Mesedez, izena eta adina ondo idatzi.");
            }
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
