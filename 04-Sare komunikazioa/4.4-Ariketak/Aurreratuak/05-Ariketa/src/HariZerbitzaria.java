import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HariZerbitzaria extends Thread {
    BufferedReader sarrera;
    PrintWriter irteera;
    Socket socket = null;

    int hariZenbakia = -1;

    public HariZerbitzaria(int hariZenbakia, Socket socket) {
        this.hariZenbakia = hariZenbakia;
        this.socket = socket;

        try {
            // Sarrera irteera fluxuak sortu
            sarrera = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            irteera = new PrintWriter(this.socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String jasotakoTestua = "";
            String bidaltzekoTestua = "";
            System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + this.socket.toString());
            
            System.out.println("1. Nola berrezarri nire kontu-pasahitza?");
            System.out.println("2. Nola konektatu nire gailua Wi-Fi sare batera?");
            System.out.println("3. Nola konpondu nire inprimagailuko inprimatze-arazoak?");
            System.out.println("4. Zein urrats eman behar ditut nire sistema eragilearen softwarea eguneratzeko?");
            System.out.println("5. Nola kopia ditzaket nire fitxategi garrantzitsuak?");
            System.out.println("0. Irten");
            System.out.print("Sartu aukera bat: ");
			irteera.close();
			sarrera.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
