public class Kola {
	private int zenbakia;
	private boolean eskuragarri = false; // Hasiera batetan kola hutsik dago
	
	public synchronized int get() {
        while(!this.eskuragarri) // kola eskuragarri ez dagoen bitartean, itxaron
        {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        this.eskuragarri = false;
        notifyAll(); // Abisatu gainontzeko objektu guztien
        return this.zenbakia;
    }
    
    public synchronized void put(int balioa) {
        while (this.eskuragarri) // kola eskuragarri baldin badago, itxaron
        {
            try {
                wait();
            } catch (InterruptedException e) { } 
        }
        this.zenbakia = balioa;
        this.eskuragarri = true;
        notifyAll(); // Abisatu gainontzeko objektu guztien
    }

    
}