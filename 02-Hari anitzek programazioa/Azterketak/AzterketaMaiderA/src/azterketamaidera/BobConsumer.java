package azterketamaidera;

import java.util.Random;

/**
 *
 * @author maider
 */
public class BobConsumer extends Thread {
    // Aldagaia
    private Mugimendua mugimendua;

    // Eraikitzailea
    public BobConsumer(Mugimendua mugimendua) {
        this.mugimendua = mugimendua;
    }

    @Override
    public void run() {
        while (mugimendua.unekoDirua() > 0) { // Uneko dirua 0 baino gehiago bada dirua kendu
            mugimendua.diruaAtera(15); // Dirua kentzeko metodoari deitu
            try {
                Random random = new Random(); // Random-a deklaratu gero segunduak ausaz egiteko
                int denbora = random.nextInt(1000,30001); // Segundu bateko eta hiru segunduko itxaropena egiteko
                Thread.sleep(denbora); // Ausazko denbora itxaron
            } catch (Exception e) {
                e.printStackTrace();
                return; // Atera
            }
        }
    }

}
