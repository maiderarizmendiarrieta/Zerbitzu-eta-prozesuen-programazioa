public class Gela {
    private Ikaslea[] ikasleak = new Ikaslea[10];

    public Gela() {
        String izenak[] = {"Oihane", "Itoitz", "Julen", "Maddi", "Irai", "Jon", "Aritz", "Unax", "Nahia", "Elene"};
        for (int i = 0; i < izenak.length; i++) {
            int agurra = (int) (Math.random()*6) + 5; //5 eta 10 artean
            ikasleak[i] = new Ikaslea(izenak[i], agurra);
        }
    }

    public void klaseaHasi() {
        // Ikasleen hariak hasi
        for (Ikaslea i : ikasleak) {
            i.start();
        }

        Irakaslea irakaslea = new Irakaslea(ikasleak);
        irakaslea.start();
    }

    public static void main(String[] args) {
        Gela gela = new Gela();
        gela.klaseaHasi();
    }
}
