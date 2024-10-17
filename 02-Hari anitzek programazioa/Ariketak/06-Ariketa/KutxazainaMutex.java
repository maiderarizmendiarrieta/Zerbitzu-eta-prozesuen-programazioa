public class KutxazainaMutex {
    // Mutexa sortu
    private static final Object mutex = new Object();

    static class NireKutxazainHaria extends Thread {
        private String izena;

        public NireKutxazainHaria(String izena){
            this.izena = izena;
        }

        public void run(){
            try {
                System.out.println(izena + " : baimena lortu nahian...");

                // Mutexa erabili
                synchronized (mutex) {
                    System.out.println(izena + " : lortu dut baimena!");
                    long denb = (long) (1000 + Math.random() * 2000); // 1-2seg artean
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(izena + " : kutxainean lanean " + i);
                        Thread.sleep(denb);
                    }
                }

                //Beste hariak baimena lortzeko mutexa askatu eta gero
                System.out.println(izena + " : baimena askatu dut...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 10 edo gehiagoko harien instantziak
        for (int i = 1; i <= 10; i++) {
            NireKutxazainHaria kutxazaina = new NireKutxazainHaria("Kutxazaina-" + i);
            kutxazaina.start();
        }
    }
}

