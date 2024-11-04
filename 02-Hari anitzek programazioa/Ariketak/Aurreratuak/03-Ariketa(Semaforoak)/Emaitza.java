public class Emaitza {
    private long gehiketaTotala = 0;

    public long getGehiketaTotala(){
        return gehiketaTotala;
    }

    public synchronized void gehituTotalera(long balioa) {
        gehiketaTotala += balioa;
    }
}
