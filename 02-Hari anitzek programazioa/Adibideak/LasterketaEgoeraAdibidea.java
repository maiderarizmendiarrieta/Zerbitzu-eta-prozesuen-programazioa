public class LasterketaEgoeraAdibidea {
    public static void main(String[] args) {
        Kontagailua konta = new Kontagailua();
        // Bi hari sortuko dira kontagailu berdina gainidatziko dutenak
        Thread thread1 = new Thread(new Batukaria(konta));
        Thread thread2 = new Thread(new Batukaria(konta));
        // Hariak abiaraztea
        thread1.start();
        thread2.start();
        try {
            thread1.join();// thread1 hariak bukatu arte zain egotea
            thread2.join();// thread2 hariak bukatu arte zain egotea
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Kontagailuaren azken balioa erakustea
        System.out.println("Kontagailua: " + konta.getKonta());
    }
}

class Kontagailua {
    private int k = 0;

    public void batu() {
        k++;
    }
    public int getKonta() {
        return k;
    }
}

class Batukaria implements Runnable {
    private Kontagailua konta;

    public Batukaria(Kontagailua konta) {
        this.konta = konta;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            konta.batu();
        }
    }
}