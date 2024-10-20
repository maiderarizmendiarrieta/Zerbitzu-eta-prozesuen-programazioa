public class Kontsumitzailea extends Thread {
	private Kola kola;
	private int n;
	
	public Kontsumitzailea(Kola k, int n)
	{
		this.kola = k;
		this.n= n;
	}
	
	public void run()
	{
		int balioa = 0;
		for (int i=0; i<5; i++)
		{	
			balioa = this.kola.get(); // balioa kolatik ateratzen du
			System.out.println(i + " => Kontsumitzailea: " + this.n + " kontsumitzen: " + balioa);	
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}