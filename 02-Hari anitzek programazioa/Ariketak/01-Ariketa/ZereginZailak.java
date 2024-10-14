public class ZereginZailak implements Runnable {
    private String izena;
    int exekZenb;
    public ZereginZailak(String izena){
            this.izena=izena;
    }
    @Override
    public void run() {
            String kat;
            while (exekZenb<10){
                    for (double i=0; i<4999.99; i=i+0.04)
                    {
                            Math.sqrt(i);
                    }                   
                    kat=this.izena+" haria naiz";
                    kat+=" eta dagokidan i balioa " + exekZenb + " da.";
                    System.out.println(kat);
                    exekZenb++;   
            }
    }
}