import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class HariZerbitzaria extends Thread {
    private BufferedReader sarreraFluxua;
    private PrintWriter irteeraFluxua;
    private Socket socket;
    private int hariZenbakia;
    private int ausazkoZenbakia;
    private static final int MAX_AUKERAK = 6;

    public HariZerbitzaria(int hariZenbakia, Socket s) {
        this.hariZenbakia = hariZenbakia;
        this.socket = s;
        this.ausazkoZenbakia = new Random().nextInt(100) + 1; // 1-100 artean
        try {
            sarreraFluxua = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            irteeraFluxua = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin konektatuta: " + this.socket.toString());
        try {
            irteeraFluxua.println("Zenbakia asmatu behar duzu (1-100 bitartean). 6 aukera dituzu!");
            int aukeraKopurua = 0;
            boolean asmatu = false;

            while (aukeraKopurua < MAX_AUKERAK && !asmatu) {
                irteeraFluxua.print("Zure aukera: ");
                irteeraFluxua.flush();
                String jasotakoa = sarreraFluxua.readLine();
                
                try {
                    int bezeroZenbakia = Integer.parseInt(jasotakoa.trim());
                    aukeraKopurua++;

                    if (bezeroZenbakia == ausazkoZenbakia) {
                        irteeraFluxua.println("ZORIONAK! Asmatu duzu zenbakia: " + ausazkoZenbakia);
                        asmatu = true;
                    } else if (bezeroZenbakia < ausazkoZenbakia) {
                        irteeraFluxua.println("Zenbaki HANDIAGOA da.");
                    } else {
                        irteeraFluxua.println("Zenbaki TXIKIAGOA da.");
                    }
                } catch (NumberFormatException e) {
                    irteeraFluxua.println("Mesedez, zenbaki baliodun bat idatzi.");
                }
            }

            if (!asmatu) {
                irteeraFluxua.println("Tamalez, ez duzu asmatu. Zenbakia hau zen: " + ausazkoZenbakia);
            }

            irteeraFluxua.println("Jarraitu nahi duzu? (bai/ez)");
            String erantzuna = sarreraFluxua.readLine();
            if ("bai".equalsIgnoreCase(erantzuna.trim())) {
                this.ausazkoZenbakia = new Random().nextInt(100) + 1; // Zenbaki berria
                run(); // Jokoa berriro hasi
            } else {
                irteeraFluxua.println("Agur!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sarreraFluxua.close();
                irteeraFluxua.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") itxi da.");
        }
    }
}
