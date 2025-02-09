
package pkg05;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author maider
 */
public class Pertsona extends Thread {
    private int id;
    private Semaphore gela;
   
    public Pertsona(int id, Semaphore gela) {
        this.id = id;
        this.gela = gela;
    }
    
    public void run() {
    try {
        System.out.println("Pertsona " + id + " gelara sartzeko zain dago.");
        gela.acquire();
        System.out.println("Pertsona " + id + " gelara sartu da.");
        Random random = new Random();
        int n = random.nextInt(1000,5001);
        Thread.sleep(n);
        System.out.println("Pertsona " + id + " NAN-a berritu duenez gelatik irten da.");
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        gela.release();}
    }
}
