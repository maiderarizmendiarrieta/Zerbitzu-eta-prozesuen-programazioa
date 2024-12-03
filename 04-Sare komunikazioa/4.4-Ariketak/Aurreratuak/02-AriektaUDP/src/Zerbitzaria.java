import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Zerbitzaria {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
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
                int bezeroZenbakia = Integer.parseInt(new String(receivedPacket.getData(), 0, receivedPacket.getLength()).trim());
                System.out.println("Mezua jaso " + bezeroHelbidea + ":" + bezeroPortua + " helbidetik: " + bezeroZenbakia);

                // Ausazko zenbaki bat sortu
                Random random = new Random();
                int n = random.nextInt(100); // 0 - 99 bitartekoa
                System.out.println("Ausazko zenbakia sortu da: " + n);

                // Erantzuna bidali (bezeroari zenbakia eta ausazko zenbakia batuta)
                int result = bezeroZenbakia + n;
                String erantzuna = String.valueOf(result);
                byte[] erantzunaData = erantzuna.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(erantzunaData, erantzunaData.length, bezeroHelbidea, bezeroPortua);
                socket.send(sendPacket);
                System.out.println("Erantzuna bidali: " + result);
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