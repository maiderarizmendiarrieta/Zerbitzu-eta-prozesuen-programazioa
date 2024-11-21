/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketamaiderarizmendiarrieta;
import java.util.Random;

/**
 *
 * @author maider
 */
public class Pultsularia extends Thread {
    // Aldagaiak
    private String izena;
    private final Random random = new Random(); // Tira egitea ausaz egiteko
    
    // Eraikitzailea
    public Pultsularia(String izena) {
        this.izena = izena;
    }
    
    // Getter & Setter-ak
    public String getIzena() {
        return izena;
    }
    
    public void setIzena(String izena) {
        this.izena = izena;
    }
    
    @Override
    public void run() {
        // [0,4] bitarteko indarra -> gero hari p1-aren ausazko tira zenb hartu
        
        int tira = random.nextInt(-4,5); // tira egiteko indarra ausaz izateko, -4 eta 4 bitarteko indarra
        if (tira > 0) {
            System.out.println(">>>>>>>>>>>>>>>TIRA ALICEK");
        } else {
            System.out.println("TIRA BOBEK<<<<<<<<<<<<<<<");
        }
    }
}
