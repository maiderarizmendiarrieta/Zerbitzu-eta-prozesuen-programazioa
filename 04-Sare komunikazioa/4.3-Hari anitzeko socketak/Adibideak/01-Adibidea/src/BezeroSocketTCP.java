import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class BezeroSocketTCP {
    public static void main(String[] args) throws Exception {
		String host = "localhost";  //ordezteko kideak zerbitzaritik emandako IP sartuta
		int port = 6000;
		
		System.out.println("Socket TCP BEZEROA martxan... ");
		
		//Socketa ireki
		Socket bezeroa = new Socket(host, port);
		
		//ESKAERA EGIN:
		// Bezeroaren irteera fluxua zerbitzariari mezuak bidaltzeko
	
		//ERANTZUNA JASO:
		// Bezeroaren sarrera fluxua zerbitzaritik mezuak irakurtzeko
		BufferedReader br = new BufferedReader(new InputStreamReader(bezeroa.getInputStream()));
		
		String jasotakoTestua = br.readLine(); // Zerbitzariaren erantzuna jaso
		//ERANTZUNA PROZESATU:
		System.out.println("Erantzuna: " + jasotakoTestua);
		
		//Fluxuak eta socketak itxi
		System.out.println("Konexioak ixten...");
		br.close();		
		bezeroa.close();
		System.out.println("Socket TCP BEZEROA itzalita. Agur!");		
	}
}
