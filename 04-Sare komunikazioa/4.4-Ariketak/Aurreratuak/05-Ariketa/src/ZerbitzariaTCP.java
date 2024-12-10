import java.net.ServerSocket;
import java.net.Socket;

public class ZerbitzariaTCP {
    public static void main(String[] args) {
        ServerSocket zerbitzaria;
        Socket bezeroa;
        HariZerbitzaria hariZerbitzaria;
        int hariZenbatzailea = 0;
        
        try {
            zerbitzaria = new ServerSocket(12345);
            System.out.println("Zerbitzaria martxan...");

            while (true) {
                bezeroa = new Socket();
                bezeroa = zerbitzaria.accept();
                hariZenbatzailea ++;
                hariZerbitzaria = new HariZerbitzaria(hariZenbatzailea, bezeroa);
				hariZerbitzaria.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}
