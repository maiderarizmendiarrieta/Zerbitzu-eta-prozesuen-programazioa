import java.util.concurrent.Semaphore;

public class Kutxazaina {
    // Gehienez 4 pertsona
    static Semaphore semaphore;// = new Semaphore(3);

    static class NireKutxazainHaria extends Thread {
        // Izena
        private String name = "";

        // Sortzailea
        NireKutxazainHaria(String name) {
            this.name = name;
        }

        public void run() {
            try {
                System.out.println(name + " : baimena lortu nahian...");
                System.out.println(
                        name + " : eskuragarri dauden Semaforoak orain bertan: " + semaphore.availablePermits());
                semaphore.acquire(); //Baimena lortzeko
                System.out.println(name + " : lortu dut baimena!");
                try {
                    long denb = (long) (1000 + Math.random() * 3000); // 1-3 segunduen artean
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(name + " : kutxazainean lanean " + i
                                + ", eskuragarri dauden Semaforoak : "
                                + semaphore.availablePermits());
                        // Segundu 1 itxaron
                        Thread.sleep(denb);
                    }
                } finally {
                    // baimena askatzen
                    System.out.println(name + " : baimena askatzen...");
                    semaphore.release();
                    System.out.println(
                            name + " : eskuragarri dauden Semaforoak orain bertan: " + semaphore.availablePermits());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Semaforoaren baimen kopurua dinamikoki
        int semaforoBaimenak = 4; // 4 kutxazain
        semaphore = new Semaphore(semaforoBaimenak);

        System.out.println("Guztira eskuragarri dauden Semaforoak: " + semaphore.availablePermits());

        // 10< hariak instantziak sortzen
        for (int i = 1; i <= 10; i++) {
            NireKutxazainHaria kutxazaina = new NireKutxazainHaria("Kutxazaina-" + i);
            kutxazaina.start();
        }

        // NireKutxazainHaria t1 = new NireKutxazainHaria("A");
        // t1.start();

        // NireKutxazainHaria t2 = new NireKutxazainHaria("B");
        // t2.start();

        // NireKutxazainHaria t3 = new NireKutxazainHaria("C");
        // t3.start();

        // NireKutxazainHaria t4 = new NireKutxazainHaria("D");
        // t4.start();

        // NireKutxazainHaria t5 = new NireKutxazainHaria("E");
        // t5.start();

        // NireKutxazainHaria t6 = new NireKutxazainHaria("F");
        // t6.start();
    }
}
