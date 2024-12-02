package udp;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import model.Ikaslea;

public class ZerbitzariaUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            int portua = 12345;
            socket = new DatagramSocket(portua);

            byte[] data = new byte[1024];
            System.out.println("UDP Zerbitzaria martxan: portua " + portua);

            while (true) {
                // Bezeroaren mezua jaso
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                socket.receive(receivePacket);
            
                // Bezeroaren helbidea eta portua
                InetAddress bezeroHelbidea = receivePacket.getAddress();
                int bezeroPortua = receivePacket.getPort();

                // Ikaslearen obj deserializatu
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                // Ikaslea jaso eta id esleitu
                Ikaslea ikaslea = (Ikaslea) objectInputStream.readObject();
                int idBerria = (int) (Math.random() * 1000); // Id-berria esleitu
                ikaslea.setId(idBerria);

                System.out.println("Mezua jaso " + bezeroHelbidea + ":" + bezeroPortua + " helbidetik: " + ikaslea);
                // Ikaslea bidali bezeroari
                System.out.println("Ikaslea jaso eta aldatu da: " + ikaslea);
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
