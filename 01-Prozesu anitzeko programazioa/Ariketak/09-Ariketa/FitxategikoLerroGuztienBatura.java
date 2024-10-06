
import java.io.*;

public class FitxategikoLerroGuztienBatura {

    // Parametroan fitxategiaren izena jasoko dugu
    public static int kalkulatuBatura(String fitxategiIzena) {
        int batura = 0;
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            f = new File(fitxategiIzena);
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String lerroa;
            while ((lerroa = br.readLine()) != null) {
                try {
                    // Lerroa zenbakia bada, gehitu baturara
                    int zenbakia = Integer.parseInt(lerroa.trim());
                    batura += zenbakia;
                } catch (NumberFormatException e) {
                    // Ez da zenbaki bat, jarraitu irakurtzen
                }
            }

            br.close();
            fr.close();
        } catch (IOException ioe) {
            // Fitxategia ezin bada irakurri, 0 bueltatuko dugu
            batura = 0;
        }

        return batura;
    }

    // Proba egiteko main metodoa
    public static void main(String[] args) {
        if (args.length >= 1) {
            String fitxategiIzena = args[0];
            int batura = kalkulatuBatura(fitxategiIzena);
            System.out.println(fitxategiIzena + ": " + batura);
        } else {
            System.out.println("Ez da fitxategirik zehaztu.");
        }
    }
}
