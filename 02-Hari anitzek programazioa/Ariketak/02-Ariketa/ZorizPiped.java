import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ZorizPiped {
    static class ZorizThread extends Thread {
        private PipedOutputStream irteera;
    }
    public static void main(String[] args) {
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
