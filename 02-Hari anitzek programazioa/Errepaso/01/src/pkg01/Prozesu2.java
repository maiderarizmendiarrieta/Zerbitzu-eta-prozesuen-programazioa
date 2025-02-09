
package pkg01;

/**
 *
 * @author maider
 */
public class Prozesu2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <=5; i++) {
            System.out.println("Prozesu2: " + i);
        }
    }
}
