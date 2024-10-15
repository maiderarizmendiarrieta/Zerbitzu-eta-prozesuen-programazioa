public class Irakaslea2 extends Thread {
        private String agurra = "KAIXO DENOI";
        private String izena;
        private Object monitorea = null;

        public Irakaslea2 (Object monitorea) {
            this.monitorea = monitorea;
        }

        public void run() {
            synchronized(monitorea) {
                try {
                    monitorea.wait();
                    System.out.println(izena + " irakaslea naiz eta " + agurra);
                    Thread.sleep(2000);
                } catch (Exception e) {
                }   
                System.out.println("ISILDU da " + izena + " irakaslea ere LANEAN");
            }
        }

        // getter eta setter medotoak "zenbatAldiz" eta "izena" barne aldagaientzako

        public String getIzena() {
            return izena;
        }

        public void setIzena(String izena) {
            this.izena = izena;
        }
}
