import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Zerbitzaria {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            int portua = 12345;
            socket = new DatagramSocket(portua);

            byte[] buffer = new byte[1024];

            while (true) {
                // Bezeroaren mezua jaso
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);
            
                // Bezeroaren helbidea eta portua
                InetAddress bezeroHelbidea = receivePacket.getAddress();
                int bezeroPortua = receivePacket.getPort();

                // Mezuaren edukia
                String mezua = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Mezua jaso " + bezeroHelbidea + ":" + bezeroPortua + " helbidetik: " + mezua);

                // Izena eta adina banatu
                String erantzuna;
                try {
                    String[] parts = mezua.split(" ");
                    String izena = parts[0];
                    int adina = Integer.parseInt(parts[1]);

                    // Comprobar si el cliente es menor de edad
                    if (adina < 18) {
                        erantzuna = izena + " " + adina + " urte ditu, adingabea da.";
                    } else {
                        erantzuna = izena + " " + adina + " urte ditu, ez da adingabea.";
                    }
                } catch (Exception e) {
                    erantzuna = "Errore bat gertatu da. Mesedez, izena eta adina ondo idatzi.";
                }

                // Erantzuna bidali
                DatagramPacket sendPacket = new DatagramPacket(erantzuna.getBytes(), erantzuna.length(), bezeroHelbidea, bezeroPortua);
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}