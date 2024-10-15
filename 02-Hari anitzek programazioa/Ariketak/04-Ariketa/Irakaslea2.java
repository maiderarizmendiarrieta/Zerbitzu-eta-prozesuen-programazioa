public class Irakaslea2 extends Thread {
        private String agurra = "KAIXO DENOI";
        private String izena;

        public Irakaslea2 (String izena) {
            this.izena = izena;
        }

        public void run() {
            long denb = (long) (Math.random()*5);
            System.out.println(izena + " irakaslea naiz eta " + agurra);
            
            try {
                Thread.sleep(denb);
            } catch (Exception e) {
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
