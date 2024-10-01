import java.io.IOException;

public class BatuketaJaurtiMainProcessBuilder {
    public static void main(String[] args) {
        ProcessBuilder pb;
        pb = new ProcessBuilder("java.exe", "unieibar.Batuketa", "76", "2");
        System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua SORTU dut.");

        try {
            Process p = pb.start();
            System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua JAURTI dut.");
            p.waitFor();
            System.out.println("BatuketaJAurtiMain: BatuketaMain prozesua AMAITU da.");
        
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BatuketaJaurtiMain: Banoa lotara.");
    }
}
