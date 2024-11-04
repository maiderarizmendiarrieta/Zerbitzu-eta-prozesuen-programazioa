import java.util.LinkedList;
import java.util.Queue;

public class Liburutegia {
    private final int kapazitatea = 10;
    private Queue<String> katalogoa  = new LinkedList<>();
    private volatile Object lock = new Object();

    public synchronized void gehituLiburura(String liburua, String langilea) throws InterruptedException {
        while (katalogoa.size() == kapazitatea) {
            wait();
        }
        katalogoa.add(liburua);
        System.out.println(langilea + " gehitutako liburua: " + liburua + " | Katalogoa: " + katalogoa.size() + "/" + kapazitatea);
        notifyAll();
    }

    public synchronized String hartuLiburua(String ikaslea) throws InterruptedException {
        while (katalogoa.isEmpty()) {
            wait();
        }
        String liburua = katalogoa.poll(); //liburua katalogotik kendu
        System.out.println(ikaslea + " hartutako liburua: " + liburua + " | Katalogoa: " + katalogoa.size() + "/" + kapazitatea);
        notifyAll();

        return liburua;
    }
}