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
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                // Bezeroaren helbidea eta portua
                InetAddress bezeroHelbidea = receivePacket.getAddress();
                int bezeroPortua = receivePacket.getPort();

                // Mezuaren edukia
                String bezeroMezua = new String(receivePacket.getData(), 0, receivePacket.getLength());
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
