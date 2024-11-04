public class Langilea extends Thread{
    private Liburutegia liburutegia;
    private String izena;
    private int liburuZenbakia = 1;

    public Langilea (Liburutegia liburutegia, String izena) {
        this.liburutegia = liburutegia;
        this.izena = izena;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String liburua = "Liburua-" + liburuZenbakia;
                liburutegia.gehituLiburura(liburua, izena);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
