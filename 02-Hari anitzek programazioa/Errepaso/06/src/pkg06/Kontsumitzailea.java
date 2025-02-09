
package pkg06;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author maider
 */
public class Kontsumitzailea extends Thread {
    private Ilara ilara;
    private Random random = new Random();
    
    public Kontsumitzailea(Ilara ilara) {
        this.ilara = ilara;
    }
    
    @Override
    public void run(){
        while(true) {
            try {
                System.out.println("Kontsumitzailea itxaroten...");
                int elementua = ilara.kontsumitu();
                System.out.println("Kontsumitzailea " + elementua + " elementua kontsumitu du.");
                int n = random.nextInt(1000,5001);
                Thread.sleep(n);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ekoizlea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
