
package pkg02;

/**
 *
 * @author maider
 */
public class Main {

    public static void main(String[] args) {
        Prozesua h1 = new Prozesua("h1");
        Prozesua h2 = new Prozesua("h2");
        
        h1.balorea(5);
        h2.balorea(10);
        
        h1.start();
        h2.start();
        
    }
    
}
