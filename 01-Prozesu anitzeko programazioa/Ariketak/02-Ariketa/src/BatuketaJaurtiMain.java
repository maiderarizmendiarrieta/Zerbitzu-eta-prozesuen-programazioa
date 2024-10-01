import java.io.IOException;

public class BatuketaJaurtiMain {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Process p = null;
        Runtime r = Runtime.getRuntime();

        System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua SORTU dut.");

        
       // String[] p = {"java.exe", "Batuketa", "76", "2"};
        
        try {
            p = r.exec("java Batuketa 76 2");
            //Runtime.getRuntime().exec(p);
            System.out.println("BatuketaJaurtiMain: BatuketaMain prozesua JAURTI dut.");

            System.out.println("BatuketaJAurtiMain: BatuketaMain prozesua AMAITU da.");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("BatuketaJaurtiMain: Banoa lotara.");
    }   
}
