package model;

import java.io.Serializable;

public class Ikaslea implements Serializable {
    private int id;
    private String izena;
    private int adina;
    private float eskolaraDistantzia;
    
    public Ikaslea(String izena, int adina, float eskolaraDistantzia) {
        this.izena = izena;
        this.adina = adina;
        this.eskolaraDistantzia = eskolaraDistantzia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getAdina() {
        return adina;
    }

    public void setAdina(int adina) {
        this.adina = adina;
    }

    public float getEskolaraDistantzia() {
        return eskolaraDistantzia;
    }

    public void setEskolaraDistantzia(float eskolaraDistantzia) {
        this.eskolaraDistantzia = eskolaraDistantzia;
    }

    @Override
    public String toString() {
        return "Ikaslea [id=" + id + ", izena=" + izena + ", adina=" + adina + ", eskolaraDistantzia="
                + eskolaraDistantzia + "]";
    }
}
