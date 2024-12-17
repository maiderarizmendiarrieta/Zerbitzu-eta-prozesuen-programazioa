import java.net.ServerSocket;
import java.net.Socket;

public class ZerbitzariaTCP {
    public static void main(String[] args) {
        ServerSocket zerbitzaria;
        int portua = 12345;
        Socket bezeroa;
        HariZerbitzaria hariZerbitzaria;
        int hariZenbatzailea = 0;
        
        try {
            zerbitzaria = new ServerSocket(portua);
            System.out.println("Zerbitzaria martxan...");

            while (true) {
                System.out.println("Bezero baten konexioa itxaroten...");
                bezeroa = new Socket();
                bezeroa = zerbitzaria.accept();
                System.out.println("Bezero berria konektatuta: " + bezeroa);

                // Hari bat sortu bezeroa maneiatzeko
                hariZerbitzaria = new HariZerbitzaria(hariZenbatzailea, bezeroa);
				hariZerbitzaria.start(); // Haria inizializatu
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
