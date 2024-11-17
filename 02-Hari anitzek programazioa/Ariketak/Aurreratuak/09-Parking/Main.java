import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(6);
        Random random = new Random();

        try {
            for (int i = 1; i <= 30; i++) {
                Autoa a = new Autoa(i, parking);
                a.start();
                Thread.sleep(random.nextInt(2000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
