
package pkg02;

/**
 *
 * @author maider
 */
public class Prozesua extends Thread {
    private int num;
    
    public Prozesua(String izena) {
        super(izena);
    }
    
    @Override
    public void run() {
        for (int i = 0; i <= num; i++) {
            System.out.println(this.getName() +": " + i);
        }
    }
    
    public void balorea(int num) {
        this.num = num;
    }
}
