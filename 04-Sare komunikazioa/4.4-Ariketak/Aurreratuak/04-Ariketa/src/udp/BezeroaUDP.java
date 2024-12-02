package udp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import model.Ikaslea;

public class BezeroaUDP {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Zerbitzariaren helbidea eta portua
            InetAddress zerbitzariHelbidea = InetAddress.getByName("127.0.0.1");
            int zerbitzariPortua = 12345;

            // UDP socket-a sortu
            socket = new DatagramSocket();

            // Ikaslea sortu
            Ikaslea ikaslea = new Ikaslea("Jon", 17, 2.5f);

            // Ikasle obj bytes array batera bihurtu, bialdu ahal izateko
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(ikaslea);
            byte[] data = byteArrayOutputStream.toByteArray();

            // Objetua bidaltzeko paketea sortu
            DatagramPacket packet = new DatagramPacket(data, data.length, zerbitzariHelbidea, zerbitzariPortua);

            // Paketea zerbitzariari bidali
            socket.send(packet);
            System.out.println("Ikaslea bidali da: " + ikaslea);

            // Zerbitzariaren erantzuna jaso
            byte[] erantzunaData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(erantzunaData, erantzunaData.length);
            socket.receive(receivePacket);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData(), 0, receivePacket.getLength());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Ikaslea receivedIkaslea = (Ikaslea) objectInputStream.readObject();
            System.out.println("Zerbitzariaren erantzuna: " + receivedIkaslea);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

