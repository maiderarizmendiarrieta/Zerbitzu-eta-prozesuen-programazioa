import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IPHelbideaErakutsi {
    public static void main(String[] args) {
        try {
            // Sistema eragilearen izena lortu
            String osIzena = System.getProperty("os.name").toLowerCase();

            // Sistema eragilea windows dela egiaztatu
            if (osIzena.contains("win")) {
                Process p = new ProcessBuilder("ipconfig").start();
                System.out.println("Prozesua SORTU eta JAURTI da.");

                // Komandoaren irtera irakurri
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String lerroa;

                while ((lerroa = reader.readLine()) != null) {
                    System.out.println(lerroa);
                }
                reader.close();
            } else {
                System.out.println("Programa hau windows-erako da.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}