
package pkg06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maider
 */
public class Ilara {
   private final Queue<Integer> ilara = new LinkedList<>();
   private final int kapazitatea;
   
   public Ilara(int kapazitatea) {
       this.kapazitatea = kapazitatea;
   }
 
   public synchronized void ekoiztu(int elementua){
       while(ilara.size() == kapazitatea) {
           System.out.println("Ilara beteta, ekoizlea itxaroten...");
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Ilara.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
       ilara.add(elementua);
       System.out.println("Ekoizlea elementua " + elementua + " gehitu du.");
       notifyAll();
   }
   
   public synchronized int kontsumitu() throws InterruptedException{
       while(ilara.isEmpty()) {
           System.out.println("Ilara hutsik, kontsumitzailea kontsumitzeko itxaroten...");
           wait();
       }
       
       int elementua = ilara.poll();
       System.out.println("Kontsumitzailea " + elementua + " elementua kontsumitu du.");
       notifyAll();
       return elementua;
   }
}
