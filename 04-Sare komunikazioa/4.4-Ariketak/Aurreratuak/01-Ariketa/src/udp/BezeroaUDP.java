package udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BezeroaUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Zerbitzariaren helbidea eta portua
            String zerbitzariHelbidea = "127.0.0.1";
            int zerbitzariPortua = 12345;

            // UDP soketea sortu
            socket = new DatagramSocket();

            // Mezu bat bidali zerbitzariarena
            String mezua = "Kaixo zerbitzari!";
            byte[] bidalitakoData = mezua.getBytes();
            InetAddress zerbitzariInetHelbidea = InetAddress.getByName(zerbitzariHelbidea);
            DatagramPacket sendPacket = new DatagramPacket(bidalitakoData, bidalitakoData.length, zerbitzariInetHelbidea, zerbitzariPortua);
            socket.send(sendPacket);
            
            // Zerbitzariaren erantzuna jaso
            byte[] erantzunaData = new byte[1024];
            DatagramPacket receivPacket = new DatagramPacket(erantzunaData, erantzunaData.length);
            socket.receive(receivPacket);

            // Erantzuna erakutsi
            String erantzuna = new String(receivPacket.getData(), 0, receivPacket.getLength());
            System.out.println("Zerbitzariaren erantzuna: " + erantzuna);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
