import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ZerbitzariSocketTCP {
    public static void main(String[] args) {
		ServerSocket zerbitzaria;
		Socket bezeroa;
		HariZerbitzaria hariZerbitzaria;
		int port = 6000;
		try {
			//ESKAERAK JASOTZEKO SOCKETA PRESTATU
			zerbitzaria = new ServerSocket(port);
			InetAddress host = InetAddress.getLocalHost(); 
			System.out.println("MAIN Zerbitzaria martxan " + host.getHostAddress() + ":" + port);
			
			while(true)
			{
				bezeroa = new Socket();
				//ITXARON ESKAERA JASO ARTE
				bezeroa = zerbitzaria.accept(); 
				//ESKAERARI ERANTZUNGO DION UMEA SORTU
				hariZerbitzaria = new HariZerbitzaria(bezeroa);
				hariZerbitzaria.start(); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}