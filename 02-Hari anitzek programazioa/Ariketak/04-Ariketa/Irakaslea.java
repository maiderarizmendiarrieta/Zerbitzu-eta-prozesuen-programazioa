public class Irakaslea extends Thread{
    private Ikaslea[] ikasleak;
    String agurra = "KAIXO DENOI";

    public Irakaslea(Ikaslea[] ikasleak){
        this.ikasleak = ikasleak;
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(agurra);

        // Agurra esandakoan klasea hasiko da ikasleen ekintzak gelditzen
        for (Ikaslea ikaslea : ikasleak) {
            ikaslea.interrupt(); //Ikasleen hariak gelditzen dira
        }
    }
}
