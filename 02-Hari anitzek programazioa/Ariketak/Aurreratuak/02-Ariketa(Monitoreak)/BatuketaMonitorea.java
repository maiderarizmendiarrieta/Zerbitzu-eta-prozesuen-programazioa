public class BatuketaMonitorea {
    private long batuketaTotala = 0;
    private int hariKonpletatuak = 0;

    public synchronized void batuketaGehitu(long batuketaPartziala) {
        batuketaPartziala += batuketaPartziala;
        hariKonpletatuak++;

        if (hariKonpletatuak == 4) {
            notifyAll();
        }
        
    }

    public synchronized long getBatuketaTotala()  throws InterruptedException{
        while (hariKonpletatuak < 4) {
            wait();
        }
    
        return batuketaTotala;
    }
}
