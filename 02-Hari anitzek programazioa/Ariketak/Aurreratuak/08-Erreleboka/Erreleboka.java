public class Erreleboka {
    private final int korrikalariak = 4;
    private int korrikalari = 1;
    public static void main(String[] args) {
        Erreleboka erreleboka = new Erreleboka();
        erreleboka.karreraHasi();
    }

    public void karreraHasi() {
        Thread[] hariak = new Thread[korrikalariak];
        for (int i = 0; i < hariak.length; i++) {
            final int kId = 1 + i;
            hariak[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    korrikaEgin(kId);
                }
            });
        }

        System.out.println("Hari guztiak sortuta.");
        System.out.println("Ready, set, go!");

        // Hariak hasieratu
        for (Thread thread : hariak) {
            thread.start();
        }

        // Amaitu arte itxaroteko
        for (Thread thread : hariak) {
            try {
                thread.join();
            } catch (Exception e) { e.printStackTrace(); }
        }

        System.out.println("Hari guztiak amaitu dute");
    }

    public synchronized void korrikaEgin(int kId) {
        while (kId != korrikalari) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Korrikalari " + kId + " naiz eta korrika egiten ari naiz...");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (korrikalari < korrikalariak) {
            System.out.println("Amaitu dut, erreleboa " + (kId+1) +" korrikalariari pasatzen...");
        } else {
            System.out.println("Bukatu dut");
        }

        // Hurrengo korrikalariari pasatu borra
        korrikalari++;
        notifyAll(); // Beste hariak abisatu
        try {
            Thread.sleep(2000); // Borra pasatu ondoren itxaron
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}