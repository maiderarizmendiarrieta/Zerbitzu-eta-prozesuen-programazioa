import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ZorizJaurti {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Zoriz");
            Process p = pb.start();

            // Prozesuaren sarrera eta irtera
            InputStream pIrtera = p.getInputStream();
            OutputStream pSrrera = p.getOutputStream();
            Scanner pScanner = new Scanner(pIrtera);
            while (true) {
                System.out.print("Sartu testu bat (buka idatzi prozesua amaitzeko): ");
                String sarrera = in.nextLine();
            
                // Testua semeari bidali
                pSrrera.write((sarrera + "\n").getBytes());
                pSrrera.flush(); // testua bialtzen dala ziurtatzeko

                if (sarrera.equalsIgnoreCase("buka")) {
                    break;
                }

                // Semeak bidalitako zenbakia irakurtzeko
                if (in.hasNextLine()) {
                    String erantzuna = pScanner.nextLine();
                    System.out.println("Semeak sortutako zenbakia: " + erantzuna);
                }
            }

            p.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } 
    }
}
