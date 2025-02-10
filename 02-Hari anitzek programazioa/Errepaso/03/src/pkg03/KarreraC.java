
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
public class KarreraC {
    private ArrayList<KorrikalariaC> corredores;
    private Semaphore semaforo;
    
    public KarreraC () {
        this.semaforo = new Semaphore(4);
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }
}
