public class Ikaslea extends Thread {
    private Liburutegia liburutegia;
    private String izena;

    public Ikaslea(Liburutegia liburutegia, String izena) {
        this.liburutegia = liburutegia;
        this.izena = izena;
    } 

    @Override
    public void run() {
        while (true) {
            try {
                liburutegia.hartuLiburua(izena);
                Thread.sleep(1500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
