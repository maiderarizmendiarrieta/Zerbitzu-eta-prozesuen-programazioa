import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ZerbitzariaSocketTCP {
    public static void main(String[] args) {
        ServerSocket zerbitzaria;
        Socket bezeroa;
        HariZerbitzaria hariZerbitzaria;
        int hariZenbatzailea = 0;
        try {
            zerbitzaria = new ServerSocket(6000);
            System.out.println("Zerbitzaria martxan...");
            
            while (true) {
                bezeroa = zerbitzaria.accept(); // bezero baten zai
                hariZenbatzailea++;
                hariZerbitzaria = new HariZerbitzaria(hariZenbatzailea, bezeroa);
                hariZerbitzaria.start(); // haria martxan jarri
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
