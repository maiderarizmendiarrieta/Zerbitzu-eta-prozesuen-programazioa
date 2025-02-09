
package pkg03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maider
 */
public class Karrera {
    private static final int numRonda = 3;
    private static final int numKorrikalari = 9;
    
    public static void karreraHasi(int ronda) {
        System.out.println("Ronda " + ronda);
        for (ronda = 0; ronda <= 3; ronda++) {
            List<String> ordena = new ArrayList<>();
            Semaphore semaforoa = new Semaphore(4);
            List<Korrikalaria> korrikalariak = new ArrayList<>();
            for (int i = 0; i <= numKorrikalari; i++) {
                Korrikalaria korrikalaria = new Korrikalaria(i, ordena, semaforoa);
                korrikalariak.add(korrikalaria);
                korrikalaria.start();
            }
            
            for(Korrikalaria k : korrikalariak) {
                try {
                    k.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Karrera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            synchronized (ordena) {
            System.out.println("Errondako ordena " + ronda + ": " + ordena.toString());
            }
        }
    }
    
     public static void main(String[] args) throws InterruptedException {
        for (int ronda = 1; ronda <= numRonda; ronda++) {
            karreraHasi(ronda);
        }

        System.out.println("\n--- Karrera amaitu da ---");
    }
}
