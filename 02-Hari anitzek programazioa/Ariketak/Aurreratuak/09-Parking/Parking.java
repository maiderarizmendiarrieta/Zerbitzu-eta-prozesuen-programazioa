import java.util.concurrent.Semaphore;

public class Parking {
    private int totalSpaces;
    private Autoa[] plazas;
    private Semaphore semaphore;

    public Parking (int totalSpaces) {
        this.totalSpaces = totalSpaces;
        this.plazas = new Autoa[totalSpaces];
        this.semaphore = new Semaphore(totalSpaces);
    }

    public Semaphore getSemaphore() {
        return this.semaphore;
    }

    public int getTotalSpaces() {
        return this.totalSpaces;
    }

    void asignarPlaza (Autoa autoa) {
        try {
            System.out.println();
            this.semaphore.acquire();
            for (int i = 0; i < plazas.length; i++) {
                if (plazas[i] == null) {
                    plazas[i] = autoa;
                    System.out.println("El coche " + plazas[i].getId_() + " se ha aparcado en la plaza " + i);
                    totalSpaces--;
                    return;
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void desasignarPlaza(Autoa autoa) {
        try {
            for (int i = 0; i < plazas.length; i++) {
                if (plazas[i] != null && plazas[i].getId_() == autoa.getId_()) {
                    plazas[i] = null;
                    System.out.println("El coche " + autoa.getId_() + " ha salido de la plaza " + i);
                }
            }
            totalSpaces++;
            this.semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
