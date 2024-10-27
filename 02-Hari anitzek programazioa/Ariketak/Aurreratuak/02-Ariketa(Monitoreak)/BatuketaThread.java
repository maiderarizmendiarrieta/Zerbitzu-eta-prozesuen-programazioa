public class BatuketaThread extends Thread{
    private int hasiera;
    private int bukaera;
    private BatuketaMonitorea monitorea;

    public BatuketaThread(int hasiera, int bukaera, BatuketaMonitorea monitorea) {
        this.hasiera = hasiera;
        this.bukaera = bukaera;
        this.monitorea = monitorea;
    }

    @Override
    public void run() {
        long batuketaPartziala = 0;
        for (int i = hasiera; i <= bukaera; i++) {
            batuketaPartziala += i;
        }
        monitorea.batuketaGehitu(batuketaPartziala);
    }
}
