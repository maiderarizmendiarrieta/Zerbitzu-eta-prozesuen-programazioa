package udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ZerbitzariaUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            // Zerbitzariaren portua eta IP helbidea
            int portua = 12345;
            socket = new DatagramSocket(portua);
            System.out.println("UDP Zerbitzaria martxan: portua " + portua);

            byte[] buffer = new byte[1024];

            while (true) {
                // Bezeroaren mezua jaso
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivedPacket);

                // Bezeroaren helbidea eta portua
                InetAddress bezeroHelbidea = receivedPacket.getAddress();
                int bezeroPortua = receivedPacket.getPort();

                // Mezuaren edukia
                String bezeroMezua = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Mezua jaso " + bezeroHelbidea + ":" + bezeroPortua + " helbidetik: " + bezeroMezua);
            
                // Erantzuna bidali
                String erantzuna = "Kaixo, " + bezeroHelbidea + "!" + " Zer moduz zaude?";
                byte[] erantzunaData = erantzuna.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(erantzunaData, erantzunaData.length, bezeroHelbidea, bezeroPortua);
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
