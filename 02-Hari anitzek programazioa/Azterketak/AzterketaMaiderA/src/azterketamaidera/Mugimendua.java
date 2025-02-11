package azterketamaidera;


/**
 *
 * @author maider
 */
public class Mugimendua {
    // Aldagaiak
    private int kontuTotala = 100;

    // Eraikitzailea
    public Mugimendua(int kontuTotala) {
        this.kontuTotala = kontuTotala;
    }

    // Dirua gehitzeko metodoa
    public synchronized void diruaGehitu(int saldoraGehitu) {
         if (kontuTotala <= 0) { // Saldua 0 bada zihurtatu
            System.out.println("Saldoa ez da nahikoa, banatu gara.");
            return;
        }
        System.out.println("---------------DIRUA SARTU");
        System.out.println("Aurreko saldoa: " + kontuTotala);
        kontuTotala += saldoraGehitu; // Balorea gehitu
        System.out.println("Agindu emailea: ALICE");
        System.out.println("Saldo berria: " + kontuTotala);
        notifyAll(); // Notifikatu
    }

    // Dirua kentzeko metodoa
    public synchronized void diruaAtera(int diruaKendu) {
        while (kontuTotala < diruaKendu) { // Saldo askorik ez badago
            if (kontuTotala <= 0) { // Saldoa 0 bada zihurtatu
            System.out.println("Saldoa ez da nahikoa, banatu gara.");
            return;
        }
            try {
                System.out.println("Ez dago saldo nahikorik. Itxaroten...");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("---------------DIRUA ATERA");
        System.out.println("Aurreko saldoa: " + kontuTotala);
        kontuTotala -= diruaKendu; // Kontu totalari dirua kendu
        System.out.println("Agindu emailea: BOB");
        System.out.println("Saldo berria: " + kontuTotala);
        notifyAll(); // Notifikatu
    }
    
    // Une honetan zenbat diru dagoen konprobatzeko
    public int unekoDirua() {
        int unekoDirua = kontuTotala;
        return unekoDirua;
    }

}
