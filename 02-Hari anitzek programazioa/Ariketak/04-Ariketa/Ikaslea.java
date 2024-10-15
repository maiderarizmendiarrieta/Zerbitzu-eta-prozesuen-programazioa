public class Ikaslea extends Thread {
    String agurrak[] = { "kaixo!", "eup!", "zelan?", "eeeepa!", "faktos!" };
    int zenbatAldiz = 5;
    String izena;

    public Ikaslea(String izena, int zenbatAldiz) {
        this.izena = izena;
        this.zenbatAldiz = zenbatAldiz;
    }

    public void run() {
        // Auzazko kodea exekutatu "zenbatAldiz" aldiz
        for (int i = 0; i < zenbatAldiz; i++) {
            int ausaz = (int) (Math.random() * agurrak.length); // agurrak ausaz atera
            // Pantailaratu honelako zerbait
            System.out.println("Nire izena " + izena + " da: " + agurrak[ausaz]);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (Exception e) {
                System.out.println(izena + " haria eten da");
                break;
            }

        }
    }

    /* BESTE MODU BAT
     * public void run() {
        * // Auzazko kodea exekutatu "zenbatAldiz" aldiz
        * Random ausaz = new Random();
        * for (int i = 0; i <zenbatAldiz; i++) {
            * // Pantailaratu honelako zerbait
            * System.out.println("Nire izena " + izena + " da: " + agurrak[i]);
            * try {
                * Thread.sleep(ausaz.nextLong(5000));
            * } catch (Exception e) {
                * System.out.println(izena + " haria eten da");
                * break;
            * }
        * 
        * }
     * }
     */

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

}