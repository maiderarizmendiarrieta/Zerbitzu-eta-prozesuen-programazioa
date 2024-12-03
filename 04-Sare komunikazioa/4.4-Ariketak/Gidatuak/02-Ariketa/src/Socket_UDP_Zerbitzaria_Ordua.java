import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Socket_UDP_Zerbitzaria_Ordua {
	//private static String ipZerbitzaria = "localhost";
    private static int portZerbitzaria = 5555;

    public static void main(String[] args) {
        System.out.println("Zerbitzaria MARTXAN!");

        try (DatagramSocket datagramSocket = new DatagramSocket(portZerbitzaria)) {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(receivedPacket);

				// Mezua jaso
                String mezua = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                InetAddress bezeroHelbidea = receivedPacket.getAddress();
                int bezeroPortua = receivedPacket.getPort();

                System.out.println("Jasotako mezua: " + mezua);
                String erantzuna;

				// Bezeroaren aukeraren arabera
                switch (mezua.trim()) {
					
					// Zerbitzaria itzali
                    case "0":
                        erantzuna = "Zerbitzaria itzaltzen...";
                        System.out.println(erantzuna);
                        datagramSocket.send(new DatagramPacket(erantzuna.getBytes(), erantzuna.length(), bezeroHelbidea, bezeroPortua));
                        return;
					
					// Uneko ordua jaso
                    case "1":
                        erantzuna = new SimpleDateFormat("HH:mm:ss").format(new Date());
                        break;

					// Uneko data jaso
                    case "2":
                        erantzuna = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                        break;

					// Bezeroa agurtu
                    case "3":
                        erantzuna = "Kaixo bezero!";
                        break;
					
                    default:
                        erantzuna = "Ezezaguna";
                }

				// Erantzuna bidali 
                byte[] erantzunaBytes = erantzuna.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(erantzunaBytes, erantzunaBytes.length, bezeroHelbidea, bezeroPortua);
                datagramSocket.send(sendPacket);
                System.out.println("Erantzuna bidali: " + erantzuna);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Zerbitzaria BUKATUTA.");
    }
}
