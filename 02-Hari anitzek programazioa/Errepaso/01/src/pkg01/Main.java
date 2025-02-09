
package pkg01;

/**
 *
 * @author maider
 */
public class Main {
    public static void main(String[] args) {
        
        Prozesu1 prozesu1 = new Prozesu1(); // Extends Thread
        Thread thread2 = new Thread(new Prozesu2()); // Implements Runnable
        
        prozesu1.start();
        thread2.start();
    } 
}
