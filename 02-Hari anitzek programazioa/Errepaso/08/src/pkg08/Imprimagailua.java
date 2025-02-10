/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg08;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maider
 */
public class Imprimagailua extends Thread {
    private int id;
    
    public Imprimagailua(int id) {
        this.id = id;
    }
    
    @Override
    public void run(){
        try {
            System.out.println("Proiektua " + id + " imprimatzeko zain");
            Imprimatu.semaforoa.acquire();
            System.out.println("Proiektua " + id + " imprimatzen...");
            Random random = new Random();
            int n =  random.nextInt(1000,3001);
            Thread.sleep(n);
            System.out.println("Proiektua " + id + " imprimatu da");
        } catch (InterruptedException ex) {
            Logger.getLogger(Imprimagailua.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Imprimatu.semaforoa.release();
        }
    }
}
