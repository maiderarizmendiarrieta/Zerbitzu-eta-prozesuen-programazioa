public class Main {
    public static void main(String[] args) throws InterruptedException {
        BatuketaMonitorea monitorea = new BatuketaMonitorea();
        int limitea = 1_000_000;
        int rangoa = limitea/4;

        BatuketaThread t1 = new BatuketaThread(1, rangoa, monitorea);
        BatuketaThread t2 = new BatuketaThread(rangoa + 1, 2 * rangoa, monitorea);
        BatuketaThread t3 = new BatuketaThread(2 * rangoa + 1, 3 * rangoa, monitorea);
        BatuketaThread t4 = new BatuketaThread(3 * rangoa + 1, limitea, monitorea);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        long batuketaTotala = monitorea.getBatuketaTotala();
        System.out.println("Lehenengo 1.000.000 zenbakien batuketa totala: " + batuketaTotala);
        
    }
}
