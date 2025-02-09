
package pkg04;

/**
 *
 * @author maider
 */
public class Main {
    private static final int num = 1000;
    private static final int hariKop = 4;
    
    public static void main(String[] args) {
        Kontadorea counter = new Kontadorea();
        for (int i = 0; i <= hariKop; i++) {
            Haria haria = new Haria(counter);
            haria.start();
        }
    }
}
