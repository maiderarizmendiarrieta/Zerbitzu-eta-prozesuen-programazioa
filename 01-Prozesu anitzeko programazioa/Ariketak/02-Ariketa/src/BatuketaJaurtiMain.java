import java.io.IOException;

public class BatuketaJaurtiMain {
    public static void main(String[] args) {
        String[] p = {"java.exe", "Batuketa", "76", "2"};
        System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua SORTU dut.");

        try {
            Runtime.getRuntime().exec(p);
            System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua JAURTI dut.");

            System.out.println("BatuketaJAurtiMain: BatuketaMain prozesua AMAITU da.");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("BatuketaJaurtiMain: Banoa lotara.");
    }   
}
