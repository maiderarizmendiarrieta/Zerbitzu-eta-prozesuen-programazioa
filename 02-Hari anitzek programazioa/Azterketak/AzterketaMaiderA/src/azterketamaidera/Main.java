
package azterketamaidera;

/**
 *
 * @author maider
 */

public class Main {
    public static void main(String[] args) {
        Mugimendua mugimendua = new Mugimendua(100); // Mugitzen den kontuari 100€ hasieratu
        
        // Hariak deklaratu
        AliceProducer alice = new AliceProducer(mugimendua);
        BobConsumer bob = new BobConsumer(mugimendua);

        // Hariak hasieratu
        alice.start(); 
        bob.start();   

        try {
            alice.join(); // Alice bukatu arte itxaron
            bob.join();   // Bob bukatu arte itxaron
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Saldoa ez da nahikoa, banatu gara.");
    }
}
