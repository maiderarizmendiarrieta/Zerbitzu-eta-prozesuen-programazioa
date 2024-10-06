import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FitxategiGuztienBatura {
    
    public static void main(String[] args) {
        // Fitxategi zerrenda
        List<String> fitxategiak = new ArrayList<>();
        fitxategiak.add("informatika.txt");
        fitxategiak.add("mekanika.txt");
        fitxategiak.add("elektronika.txt");
        fitxategiak.add("automozioa.txt");
        fitxategiak.add("administrazioa.txt");  // Fitxategi hau ez da existitzen

        System.out.println("FITXATEGI GUZTIEN BATURA HASTERA DOA!!!\n");

        // Executor zerbitzua, fitxategi bakoitza paraleloan prozesatzeko
        ExecutorService executor = Executors.newFixedThreadPool(fitxategiak.size());

        // Emaitzak gordetzeko zerrenda
        List<Future<Integer>> emaitzak = new ArrayList<>();

        // Fitxategi bakoitza prozesatu prozesu independente batean
        for (String fitxategi : fitxategiak) {
            System.out.println("'" + fitxategi + "' fitxategia irakurten hasi da prozesu bat...");
            Future<Integer> emaitza = executor.submit(() -> FitxategikoLerroGuztienBatura.kalkulatuBatura(fitxategi));
            emaitzak.add(emaitza);
        }

        // Prozesuak bukatu arte itxaron eta emaitzak erakutsi
        executor.shutdown();

        // Guztien batura kalkulatu
        int guztira = 0;
        System.out.println("\nMINTEGI BAKOITZEKO AURREKONTUEN BATURAK:");
        for (int i = 0; i < fitxategiak.size(); i++) {
            try {
                int batura = emaitzak.get(i).get();  // Emaitza lortu
                System.out.println(" " + fitxategiak.get(i) + ": " + batura);
                guztira += batura;
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Errorea prozesuan: " + fitxategiak.get(i));
            }
        }

        System.out.println("\nGUZTIRA: " + guztira);
    }
}
