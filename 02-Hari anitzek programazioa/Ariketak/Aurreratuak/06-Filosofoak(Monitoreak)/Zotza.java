public class Zotza {
    private int id;
    private int nork;
    private boolean hartuta;

    public Zotza(int id) {
        this.id = id;
        this.nork = -1;
        this.hartuta = false;
    }

    synchronized public void hartu(int nork) {
       try {
            while (hartuta) {
                wait();
            }
            this.nork = nork;
            this.hartuta = true;
            System.out.println("Filosofoa " + nork + ", " + id +". zotza hartu du");
       } catch (Exception e) {
            e.printStackTrace();
       }
    }

    synchronized public void utzi(){
        System.out.println("Filosofoa " + nork + ", " + id +". zotza utzi du");
        nork = -1;
        hartuta = false;
        notifyAll();
    }
}
