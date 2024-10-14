import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;

public class ZorizJaurti {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            // Hodiak lotu
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);

            // Semea sortu eta exekutatu
            Zoriz semea = new Zoriz(pos);
            semea.start();
            
            // Semeak bidalitakoa irakurtzeko
            BufferedReader reader = new BufferedReader(new InputStreamReader(pis));
            while (true) {
                System.out.print("Sartu hitzen bat (buka idatzi amaitzeko): ");
                String lerroa = in.nextLine();

                if (lerroa.equals("buka")) {
                    semea.interrupt();
                    break;
                }

                // Hoditik semeak idatzitako zenbakia irakurtzeko
                String zorizkoZenb = reader.readLine();
                System.out.println("Semearen zorizko zenbakia: " + zorizkoZenb);
            }
            in.close();
            pis.close();
            pos.close();
        } catch (IOException e) {
            System.out.println("Errorea hodietan: " + e.getMessage());
        }
    }
}
