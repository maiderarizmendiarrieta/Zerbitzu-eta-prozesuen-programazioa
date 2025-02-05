/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketamaiderarizmendiarrieta;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author maider
 */
public class Txapelketa {
    private int counter;
    private final Semaphore semaforoa = new Semaphore(2);
    
    public Txapelketa() {
        
    }
    
    public void tiraEgin() {
        try {
            semaforoa.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(counter!=20 || counter!=-20) {
            
            if (counter == 20) {
                System.out.println("Marka 20cm");
                //System.out.println(pultsularia.getIzena() + ": ni naiz txapelduna!");
            } else {
                System.out.println("Marka 20cm");
                //System.out.println(pultsularia.getIzena() + ": ni naiz txapelduna!");
            }
        }
    }
}
