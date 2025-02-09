/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg03;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maider
 */
public class Korrikalaria extends Thread {
    private int zenb;
    private List<String> ordena;
    private Semaphore semaforoa = new Semaphore(4);
    
    public Korrikalaria(int zenb, List<String> ordena, Semaphore semaforoa) {
        this.zenb = zenb;
        this.ordena = ordena;
        this.semaforoa = semaforoa;
    }
    
    @Override 
    public void run() {
        int denbora = (int) (Math.random() * 3000);
        try {
            Thread.sleep(denbora);
            semaforoa.acquire();
            
            try {
                System.out.println("Korrikalaria " + zenb);
                System.out.println("Korrikalaria " + zenb + " " + denbora + " segunduko denboran heldu da.");
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                semaforoa.release();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }
}
