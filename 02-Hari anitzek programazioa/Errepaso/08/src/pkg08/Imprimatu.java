
package pkg08;

import java.util.concurrent.Semaphore;

/**
 *
 * @author maider
 */
public class Imprimatu {

    public static final Semaphore semaforoa = new Semaphore(2);
    
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Imprimagailua imprimagailua = new Imprimagailua(i);
            imprimagailua.start();
        }
    }  
}
