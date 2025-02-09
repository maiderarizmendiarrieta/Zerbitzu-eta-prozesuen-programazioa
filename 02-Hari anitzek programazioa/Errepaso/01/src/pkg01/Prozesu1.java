
package pkg01;

/**
 *
 * @author maider
 */
public class Prozesu1 extends Thread {
    
    @Override
    public void run() {
        for (int i = 0; i <=5; i++) {
            System.out.println("Prozesu1: " + i);
        }
    }
}
