import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BatuketaJaurtiMainRuntime {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("deprecation")
            Process p = Runtime.getRuntime().exec("java Batuketa 11 3");
            System.out.println("BatuketaJaurtiMainRuntime: batuketa prozesua SORTU eta JAURTI da.");
            
            // Irtera irakurtzeko
            InputStream in = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String lerroa;

            while ((lerroa = reader.readLine()) != null) {
                System.out.println("BatuketaJaurtiMainRuntime: Semeak esan du: " + lerroa);
            }

            // Prozesua bukatu arte itxaron
            p.waitFor();
            reader.close();
            System.out.println("BatuketaJaurtiMainRuntime: batuketa prozesua BUKATU da.");
        
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("BatuketaJaurtiMainRuntime: Banoa lotara");
    }
}
