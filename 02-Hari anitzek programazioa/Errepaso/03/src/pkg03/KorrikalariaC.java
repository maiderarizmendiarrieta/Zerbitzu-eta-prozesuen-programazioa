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
public class KorrikalariaC extends Thread {
    private int zenb;
    private KarreraC karrera;
    
    public KorrikalariaC(int zenb, KarreraC karrera) {
        this.zenb = zenb;
        this.karrera = karrera;
    }
    
    @Override 
    public  void run() {
        try {
            synchronized(this.karrera.getSemaforo()) {
                System.out.println("Permisos disponibles: " + this.karrera.getSemaforo().availablePermits());
                this.karrera.getSemaforo().acquire();
                if (this.karrera.getSemaforo().availablePermits() < 4) {
                    System.out.println("El corredor " + this.zenb + " empieza a correr.");
                    this.karrera.getSemaforo().notifyAll();
                } else {
                    System.out.println("El corredor " + this.zenb + " esperando en la salida.");
                    this.karrera.getSemaforo().wait();
                }
                int denbora = (int) (Math.random() * 3000);
                //Thread.sleep(denbora);
                System.out.println("Korrikalaria " + zenb);
                System.out.println("Korrikalaria " + zenb + " " + denbora + " segunduko denboran heldu da.");
            }
            
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            this.karrera.getSemaforo().release();
        }
    }
}
