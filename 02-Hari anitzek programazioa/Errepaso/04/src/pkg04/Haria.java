
package pkg04;

/**
 *
 * @author maider
 */
public class Haria extends Thread {
    private Kontadorea counter;

    public Haria(Kontadorea counter) {
        this.counter = counter;
    }
    
    @Override
    public void run() {
        while(counter.getBalorea() <= 250 ) {
            int balorea = counter.gehitu();
            System.out.println(Thread.currentThread().getName() +" kontadorea handitu du: " + balorea);
            
            if ( balorea == 250) {
                System.out.println("Kontadorea balioa lortu du: " + balorea);
            }
        }
    }
}
