import java.util.Random;

public class FilosofoThread extends Thread {
    private int id;
    private Zotza eskumakoZotza;
    private Zotza ezkerrekoZotza;
    private Random random = new Random();

    public FilosofoThread(int id, Zotza eskumakoZotza, Zotza ezkerrokoZotza) {
        this.id = id;
        this.eskumakoZotza = eskumakoZotza;
        this.ezkerrekoZotza = ezkerrokoZotza;
    }

    public void run () {
        try {
            pentsatu();
            eskumakoZotza.hartu(id);
            ezkerrekoZotza.hartu(id);
            jan();
            eskumakoZotza.utzi();
            ezkerrekoZotza.utzi();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pentsatu() throws Exception {
        System.out.println("Filosofoa " + id + " pentsatzen ari da.");
        int n = random.nextInt(3000);
        Thread.sleep(n);  
        System.out.println("Filosofoa " + id + " pentsatzeari utzi egin dio.");     
    }


    public void jan() throws Exception {
        System.out.println("Filosofoa " + id + " jaten ari da.");
        int n = random.nextInt(3000);
        Thread.sleep(n);
    }
}