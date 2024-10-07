package unieibar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        try {
            // Prozesua sortu
            ProcessBuilder pb = new ProcessBuilder("java.exe", "Batuketa");
            System.out.println("BatuketaMain prozesua SORTU da.");
            
            // Erroreak berbideratzeko
            pb.redirectErrorStream(true);

            // Prozesua jaurti
            Process p = pb.start();
            System.out.println("BatuketaMain prozesua JAURTI da.");

            // Prozesuaren sarrera fluxua (aitatik semera datuak pasatzeko)
            OutputStream out = p.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            
            // Zenbakiak idatzi sarreran (prozesuak irakurtzea espero duen lekutik)
            writer.println("10");
            writer.println("20");
            writer.flush(); // Bufferretik prozesura datuak bidali
        
            // Prozesuaren irteera fluxua irakurri (semetik aitara datuak pasatzeko)
            InputStream in = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String lerroa;

            while ((lerroa = reader.readLine()) != null) {
                System.out.println("BatuketaMain: Semeak esandakoa -> " + lerroa);
            }

            //Prozesua bukatu arte itxaron
            p.waitFor();
            System.out.println("BatuketaMain: seme prozesua bukatu da.");
        
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
