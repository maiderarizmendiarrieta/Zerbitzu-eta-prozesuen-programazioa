
package pkg06;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maider
 */
public class Ekoizlea extends Thread {
    private Ilara ilara;
    private Random random = new Random();
    public Ekoizlea(Ilara ilara) {
        this.ilara = ilara;
    }
    
    @Override 
    public void run() {
        int counter = 0;
        while(true) {
            try {
                System.out.println("Ekoizlea produktua ekoizten..");
                ilara.ekoiztu(counter);
                counter++;
                int n = random.nextInt(1000,5001);
                Thread.sleep(n);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ekoizlea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
