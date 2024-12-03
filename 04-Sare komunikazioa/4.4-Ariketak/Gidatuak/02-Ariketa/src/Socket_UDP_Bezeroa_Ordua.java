import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Socket_UDP_Bezeroa_Ordua {
    private static String ipZerbitzaria = "localhost";
    private static int portZerbitzaria = 5555;

    public static void main(String[] args) {
        System.out.println("Bezeroa MARTXAN!");
		Scanner in = new Scanner(System.in);

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            String aukera;
            do {
                System.out.println("\nMENUA:");
                System.out.println("0 = PROGRAMATIK IRTEN ETA ZERBITZARIA ITZALI");
                System.out.println("1 = ORDUA GALDETU ZERBITZARIARI");
                System.out.println("2 = DATA GALDETU ZERBITZARIARI");
                System.out.println("3 = KAIXO ESAN ZERBITZARIARI");
                System.out.print("Aukeratu: ");
                aukera = in.nextLine();
				

				// Zerbitzariari mezua bialdu
                byte[] mezua = aukera.getBytes();
                InetAddress zerbitzariHelbidea = InetAddress.getByName(ipZerbitzaria); // zerbitzariaren helbidea hartu
                DatagramPacket sendPacket = new DatagramPacket(mezua, mezua.length, zerbitzariHelbidea, portZerbitzaria);
                datagramSocket.send(sendPacket);

				// Zerbitzaritik erantzuna jaso
                byte[] data = new byte[1024];
                DatagramPacket receivedPacket = new DatagramPacket(data, data.length);
                datagramSocket.receive(receivedPacket);

                String erantzuna = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Zerbitzariaren erantzuna: " + erantzuna);

            } while (!aukera.equals("0"));
			in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Bezeroa BUKATUTA.");
    }
}
