
package pkg05;

import java.util.concurrent.Semaphore;

/**
 *
 * @author maider
 */
public class Main {
    private static final int pertsonaKop = 20;
    public static void main(String[] args) {
        Semaphore semaforoa = new Semaphore(4);
        for (int i = 0; i < pertsonaKop; i++) {
            Pertsona pertsona = new Pertsona(i, semaforoa);
            pertsona.start();
        }
    }
    
}
