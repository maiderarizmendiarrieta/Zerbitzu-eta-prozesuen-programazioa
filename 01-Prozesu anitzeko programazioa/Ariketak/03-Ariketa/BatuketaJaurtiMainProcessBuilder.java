import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BatuketaJaurtiMainProcessBuilder {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java.exe", "unieibar.Batuketa", "76", "2");
        System.out.println("BatuketaJaurtiMainProcessBuilder: BatuketaMain prozesua SORTU dut.");

        //herentzian eman gurasoari bere irtera eta sarrera estandarra
        pb.inheritIO();

        try {
            Process p = pb.start();
            System.out.println("BatuketaJaurtiMainProcessBuilder: BatuketaMain prozesua JAURTI dut.");

            // BESTE MODU BAT 
            //Prozesuaren irtera irakurtzeko
            // InputStream in = p.getInputStream();
            // BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            // String lerroa;

            // while ((lerroa = reader.readLine()) != null) {
            //     System.out.println("BatuketaJaurtiMainProcessBuilder: Semeak esan du: " + lerroa);
            // }

            // Prozesua bukatu arte itxaron
            p.waitFor();
            System.out.println("BatuketaJaurtiMainProcessBuilder: BatuketaMain prozesua AMAITU da.");
        
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BatuketaJaurtiMainProcessBuilder: Banoa lotara.");
    }
}