
package pkg07;

/**
 *
 * @author maider
 */
public class Irakurlea extends Thread {
    private int id;
    private Fitxategia fitxategia;
    
    public Irakurlea(int id, Fitxategia fitxategia) {
        this.id = id;
        this.fitxategia = fitxategia;
    }
    
    @Override
    public void run() {
    
    }
}
