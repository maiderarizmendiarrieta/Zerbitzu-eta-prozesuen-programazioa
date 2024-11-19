import java.util.Random;

public class Bezeroa extends Thread {
    private int bezeroId;
    private String izena;
    private Zinema zinema;
    
    public Bezeroa(int bezeroId, String izena, Zinema zinema) {
        this.bezeroId = bezeroId;
        this.izena = izena;
        this.zinema = zinema;
    }

    public int getBezeroId() {
        return bezeroId;
    }

    public void setBezeroId(int bezeroId) {
        this.bezeroId = bezeroId;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void run() {
        Random eserlekuak = new Random();
        int numEspacios = eserlekuak.nextInt(1,6);
        System.out.println(bezeroId + "-k " + numEspacios + " eserleku nahi ditu.");
        zinema.erreserbatu(this, numEspacios);
    }
}
