import java.security.DrbgParameters.Reseed;
import java.util.concurrent.Semaphore;

import javax.naming.spi.DirStateFactory.Result;

public class GehiketaThread extends Thread {
    private final int hasiera;
    private final int bukaera;
    private final Result emaitza;
    private final Semaphore semaphore;

    public GehiketaThread(int hasiera, int bukaera, Result emaitza, Semaphore semaphore) {
        this.hasiera = hasiera;
        this.bukaera = bukaera;
        this.emaitza = emaitza;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        long gehiketaPartziala = 0;
        for (int i = hasiera; i <= bukaera; i++) {
            gehiketaPartziala += i;
        }
        emaitza.gehituTotalera(gehiketaPartziala); //batura globala eguneratu

        semaphore.release(); //semaforoa askatu, hariak bukatzen ari direla jakiteko
    }
}