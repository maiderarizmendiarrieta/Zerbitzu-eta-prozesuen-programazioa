import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Liburutegia {
    private final int kapazitatea = 10;
    private Queue<String> katalogoa  = new LinkedList<>();
    private Semaphore semaforoGehitu = new Semaphore(1); // Un semáforo para añadir libros
    private Semaphore semaforoHartu = new Semaphore(1);  // Un semáforo para tomar libros


    public void gehituLiburura(String liburua, String langilea) throws InterruptedException {
        semaforoGehitu.acquire(); // Solo un hilo puede añadir libros a la vez
        try {
            while (katalogoa.size() == kapazitatea) {
                System.out.println(langilea + " itxaroten egon behar da, katalogoa beteta dago.");
                semaforoGehitu.release();
                Thread.sleep(500); // Simula que espera un tiempo para agregar un libro
                semaforoGehitu.acquire();
            }
            katalogoa.add(liburua);
            System.out.println(langilea + " gehitutako liburua: " + liburua + " | Katalogoa: " + katalogoa.size() + "/" + kapazitatea);
        } finally {
            semaforoGehitu.release(); // Liberar el semáforo
        }
    }

    public String hartuLiburua(String ikaslea) throws InterruptedException {
        semaforoHartu.acquire(); // Solo un hilo puede tomar un libro a la vez
        try {
            while (katalogoa.isEmpty()) {
                System.out.println(ikaslea + " itxaroten egon behar da, katalogoa hutsik dago.");
                semaforoHartu.release();
                Thread.sleep(500); // Simula que espera un tiempo antes de intentar tomar un libro
                semaforoHartu.acquire();
            }
            String liburua = katalogoa.poll(); // Sacamos un libro del catálogo
            System.out.println(ikaslea + " hartutako liburua: " + liburua + " | Katalogoa: " + katalogoa.size() + "/" + kapazitatea);
            return liburua;
        } finally {
            semaforoHartu.release(); // Liberar el semáforo
        }
    }
}
