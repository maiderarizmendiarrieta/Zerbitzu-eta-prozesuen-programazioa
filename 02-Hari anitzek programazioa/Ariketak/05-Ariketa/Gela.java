import java.util.*;

public class Gela {
    public static void main(String[] args) {
        ArrayList<Ikaslea> ikasleak = new ArrayList<>();
        String ikasleIzena[] = {"Oihane", "Itoitz", "Julen", "Maddi", "Irai", "Jon", "Aritz", "Unax", "Nahia", "Elene"};
        Ikaslea ikaslea = null;
        Irakaslea irakaslea = null;
        Random ausaz = new Random();
        Object monitorea = new Object();
        

        // Ikasleak sortu eta exekutatu
        for (int i = 0; i < ikasleIzena.length; i++) {
            ikaslea = new Ikaslea(ikasleIzena[i], 5 + ausaz.nextInt(5), monitorea);
            ikasleak.add(ikaslea);
            ikaslea.start();
        }

        // Irakaslea sortu eta exekutatu
        irakaslea = new Irakaslea(monitorea);
        irakaslea.setIzena("Aitor");
        irakaslea.start();
        
        // Ikasleen hariak amaitu arte itxaron
        for (Ikaslea ikasle : ikasleak) {
            try {
                ikasle.join(); // Ikasle bakoitza amaitu arte itxaron
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (monitorea) {
            monitorea.notify();
        }

        System.out.println("Ikasleak ISILTZEN eta haien lekuetan esertzen...");

        for (int i = 0; i < ikasleak.size(); i++) {
            if (!ikasleak.get(i).isAlive()) {
                ikasleak.get(i).akabatu();
            }
        }
    }
}
