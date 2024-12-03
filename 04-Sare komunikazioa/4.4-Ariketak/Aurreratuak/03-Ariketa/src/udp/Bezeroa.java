package udp;
import java.net.*;
import java.io.*;

public class Bezeroa {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        BufferedReader userInput = null;

        try {
            // Zerbitzariaren helbidea eta portua
            InetAddress zerbitzariHelbidea = InetAddress.getByName("127.0.0.1");
            int zerbitzariPortua = 12345;

            // UDP socket-a sortu
            socket = new DatagramSocket();

            // Erabiltzailearen sarrera irakurtzeko fluxua sortu
            userInput = new BufferedReader(new InputStreamReader(System.in));

            // Erabiltzailari izena eta adina eskatzea
            System.out.print("Idatzi zure izena eta adina (adibidez: Jon 17): ");
            String mezua = userInput.readLine();

            // Zerbitzariari bidaltzeko paketea sortu
            DatagramPacket sendPacket = new DatagramPacket(mezua.getBytes(), mezua.length(), zerbitzariHelbidea, zerbitzariPortua);

            // Paketea bidali zerbitzariari
            socket.send(sendPacket);
            System.out.println("Mezua bidali da: " + mezua);

            // Zerbitzariaren erantzuna jaso
            byte[] erantzunaData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(erantzunaData, erantzunaData.length);
            socket.receive(receivePacket);

            // Zerbitzariaren erantzuna erakutsi
            String erantzuna = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Zerbitzariaren erantzuna: " + erantzuna);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();  // Socket-a itxi
                if (userInput != null) userInput.close();  // Sarrera fluxua itxi
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
