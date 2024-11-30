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
                DatagramPacket receivPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivPacket);

                // Bezeroaren helbidea eta portua
                InetAddress bezeroHelbidea = receivPacket.getAddress();
                int bezeroPortua = receivPacket.getPort();

                // Mezuaren edukia
                int bezeroZenbakia = Integer.parseInt(new String(receivPacket.getData(), 0, receivPacket.getLength()).trim());
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