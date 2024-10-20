public class Produktorea extends Thread {
	private Kola kola;
	private int n;
	
	public Produktorea(Kola k, int n)
	{
		this.kola = k;
		this.n= n;
	}
	
	public void run()
	{
		for (int i=0; i<5; i++)
		{
			this.kola.put(i); // balioa kolan gehitzen du
			System.out.println(i + " => Produktorea: " + this.n + " produzitzen: " + i);
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}