import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HariZerbitzaria extends Thread {
    private BufferedReader sarrera;
    private PrintWriter irteera;
    private Socket socket;

    private int hariZenbakia;

    public HariZerbitzaria(int hariZenbakia, Socket socket) {
        this.hariZenbakia = hariZenbakia;
        this.socket = socket;

        try {
            // Sarrera irteera fluxuak sortu
            sarrera = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            irteera = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String jasotakoTestua;
            System.out.println(
                    "HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + this.socket.toString());

            boolean jarraitu = true;
            while (jarraitu) {
                // Bezeroari menua bidali
                irteera.println("Menua:");
                irteera.println("1. Nola berrezarri nire kontu-pasahitza?");
                irteera.println("2. Nola konektatu nire gailua Wi-Fi sare batera?");
                irteera.println("3. Nola konpondu nire inprimagailuko inprimatze-arazoak?");
                irteera.println("4. Zein urrats eman behar ditut nire sistema eragilearen softwarea eguneratzeko?");
                irteera.println("5. Nola kopia ditzaket nire fitxategi garrantzitsuak?");
                irteera.println("0. Irten");
                irteera.println("Sartu aukera bat:");

                // Bezeroaren aukera irakurri
                jasotakoTestua = sarrera.readLine();
                if (jasotakoTestua.equals(null)) {
                    break;
                }

                switch (jasotakoTestua) {
                    case "1":
                        irteera.println(
                                "Kontu-pasahitza berrezartzeko: Sartu zure kontuaren konfigurazioan eta jarraitu argibideak.");
                        break;
                    case "2":
                        irteera.println(
                                "Wi-Fi konektatzeko: Joan gailuaren konfiguraziora, aukeratu sareak eta konektatu zure sarera.");
                        break;
                    case "3":
                        irteera.println(
                                "Inprimatze-arazoak konpontzeko: Egiaztatu tinta eta papera, eta berrabiarazi inprimagailua.");
                        break;
                    case "4":
                        irteera.println(
                                "Softwarea eguneratzeko: Joan sistema eragilearen eguneratze ataletara eta jarraitu argibideak.");
                        break;
                    case "5":
                        irteera.println(
                                "Fitxategiak kopiatzeko: Erabili USB edo hodei-zerbitzuak fitxategiak segurtasunez gordetzeko.");
                        break;
                    case "0":
                        irteera.println("Eskerrik asko erabiltzeagatik! Agur.");
                        jarraitu = false;
                        break;
                    default:
                        irteera.println("Aukera okerra. Saiatu berriro.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Errorea socket-a ixtean: " + e.getMessage());
            }
        }
    }
}
