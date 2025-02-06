/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketamaiderarizmendiarrieta;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maider
 */
public class Pultsularia extends Thread {
    // Aldagaiak
    //private String izenaP1;
    //private String izenaP2;
    private int counterP1;
    private int counterP2;
    private final Random random = new Random(); // Tira egitea ausaz egiteko
    
    public Pultsularia () {
        counterP1 = 0;
        counterP2 = 0;
    }

    @Override
    public void run() {
        while(counterP1<20 && counterP2>-20) {
            // [0,4] bitarteko indarra -> gero hari p1-aren ausazko tira zenb hartu
            int tira = 0;
            while (tira == 0) {
                tira = random.nextInt(-4,5); // tira egiteko indarra ausaz izateko, -4 eta 4 bitarteko indarra
            }

            if (tira > 0) {
                System.out.println(">>>>>>>>>>>>>>>TIRA ALICEK");
                this.counterP1 += tira;
                System.out.println(tira + " " + counterP1 + " " + counterP2);
            } else {
                System.out.println("TIRA BOBEK<<<<<<<<<<<<<<<");
                this.counterP2 -= Math.abs(tira);
                System.out.println(tira + " " + counterP1 + " " + counterP2);
            }
        }
        
        if (counterP1>=20) {
            System.out.println("HA GANADO DERECHA");
        } else if (counterP2<=-20) {
            System.out.println("HA GANADO IZQUIERDA");
        }
    }
}
