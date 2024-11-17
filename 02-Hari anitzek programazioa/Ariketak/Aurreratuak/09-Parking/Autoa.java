import java.util.Random;

public class Autoa extends Thread {
    private int id_;
    private Parking parking;

    private Random random = new Random();

    public Autoa(int id, Parking parking) {
        this.id_ = id;
        this.parking = parking;
    }

    public int getId_() {
        return id_;
    }

    public void run() {
        try {
            System.out.println("El coche " + id_ + " entra al parking. Coches esperando: " + parking.getSemaphore().getQueueLength() + " Espacioes disponibles: " + parking.getTotalSpaces());
            parking.asignarPlaza(this);
            Thread.sleep(random.nextInt(20000));
            parking.desasignarPlaza(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}