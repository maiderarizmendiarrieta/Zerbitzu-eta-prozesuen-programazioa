import java.util.*;

public class Gela2 {
    public static void main(String[] args) {
        ArrayList<Ikaslea2> ikasleak = new ArrayList<>();
        String ikasleIzena[] = {"Oihane", "Itoitz", "Julen", "Maddi", "Irai", "Jon", "Aritz", "Unax", "Nahia", "Elene"};
        Ikaslea2 ikaslea = null;
        Irakaslea2 irakaslea = null;
        Random ausaz = new Random();
        Object monitorea = new Object();
        

        for (int i = 0; i < ikasleIzena.length; i++) {
            ikaslea = new Ikaslea2(ikasleIzena[i], i);
            ikasleak.add(ikaslea);
            try {
                ikaslea.jarriZenbatAldiz(5+ausaz.nextInt(5));
            } catch (Exception e) {    
            }
            ikasleak.add(ikaslea);
        }

        for (int i = 0; i < ikasleak.size(); i++) {
            ikasleak.get(i).start();
        }

        irakaslea = new Irakaslea2(monitorea);
        irakaslea.setIzena("Aitor");
        irakaslea.start();
        
        // try {
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        // }

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
