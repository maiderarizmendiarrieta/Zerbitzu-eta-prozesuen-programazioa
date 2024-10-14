import java.util.Random;
import java.io.PipedOutputStream;
import java.io.IOException;

public class Zoriz extends Thread {
    private PipedOutputStream pos;

    public Zoriz(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int zorikoZenb = random.nextInt(10);
                pos.write((zorikoZenb + "\n").getBytes());
                pos.flush();

                Thread.sleep(2000);
            } catch (IOException | InterruptedException e) {
                System.out.println("Semea eten da");
                break;
            }
        }
    }
}
