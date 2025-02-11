
package azterketamaidera;

import java.util.Random;

/**
 *
 * @author maider
 */
public class AliceProducer extends Thread {
    // Aldagaia
    private Mugimendua mugimendua;
    
    // Eraikitzailea
    public AliceProducer(Mugimendua mugimendua){
        this.mugimendua = mugimendua;
    }
    
    @Override
    public void run() {
        while (mugimendua.unekoDirua() > 0 ) { // Uneko dirua 0 baino gehiago bada dirua gehitu
            mugimendua.diruaGehitu(10); // Dirua gehitzeko metodoari deitu
            try {
                Random random = new Random(); // Random-a deklaratu gero segunduak ausaz egiteko
                int denbora = random.nextInt(1000,30001); // Segundu bateko eta hiru segunduko itxaropena egiteko
                Thread.sleep(denbora); // Ausazko denbora itxaron
            } catch (InterruptedException e) {
                e.printStackTrace();
                return; // Atera
            }
        }
    }

}
