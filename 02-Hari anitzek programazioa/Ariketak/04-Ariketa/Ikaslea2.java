import java.util.Random;

public class Ikaslea2 extends Thread {
    String agurrak[] = { "kaixo!", "eup!", "zelan?", "eeeepa!", "faktos!" };
    int zenbatAldiz = 5;
    String izena;
    private volatile boolean hitlzekoEskaera = false;

    public Ikaslea2(String izena, int zenbatAldiz) {
        this.izena = izena;
        this.zenbatAldiz = zenbatAldiz;
    }

    public void run() {
        // Auzazko kodea exekutatu "zenbatAldiz" aldiz
        // Random ausaz = new Random();
        long denb = (long) (Math.random() * 5);
        for (int i = 0; i < agurrak.length; i++) {
            if (!hitlzekoEskaera) {
                System.out.println("Nire izena " + izena + " da: " + agurrak[i] + " " + (i + 1));
                try {
                    Thread.sleep(denb);
                } catch (Exception e) {
                }
            }
        }
    }

    // getter eta setter medotoak "zenbatAldiz" eta "izena" barne aldagaientzako

    public int getZenbatAldiz() {
        return zenbatAldiz;
    }

    public void setZenbatAldiz(int zenbatAldiz) {
        this.zenbatAldiz = zenbatAldiz;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void jarriZenbatAldiz(int zenb) {
        if (zenb >= 5 && zenb <= 10) {
            this.zenbatAldiz = zenb;
        } else {
            System.out.println("Zenbaki okerra: Ezarri 5 eta 10 arteko balio bat.");
        }
    }

    public void akabatu() {
        this.hitlzekoEskaera = true;
    }
}
