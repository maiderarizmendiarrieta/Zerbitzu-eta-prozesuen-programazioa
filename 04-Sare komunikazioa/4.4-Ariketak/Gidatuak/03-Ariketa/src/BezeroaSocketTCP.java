import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BezeroaSocketTCP {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 6000;

        System.out.println("Socket TCP BEZEROA martxan...");
        try (Socket bezeroa = new Socket(host, port);
            PrintWriter pwos = new PrintWriter(bezeroa.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(bezeroa.getInputStream()));
            BufferedReader brErabiltzailea = new BufferedReader(new InputStreamReader(System.in))) {

            String erantzuna;
            while ((erantzuna = br.readLine()) != null) {
                System.out.println("Zerbitzaria: " + erantzuna);
                if (erantzuna.contains("Zure aukera") || erantzuna.contains("Jarraitu nahi duzu")) {
                    String bidali = brErabiltzailea.readLine();
                    pwos.println(bidali);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Socket TCP BEZEROA itzalita. Agur!");
    }
}
