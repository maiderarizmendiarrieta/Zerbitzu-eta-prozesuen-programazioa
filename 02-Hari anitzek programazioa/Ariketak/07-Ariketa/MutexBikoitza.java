
public class MutexBikoitza extends Thread {
	private Object mutex1 = new Object();
	private Object mutex2 = new Object();
	private String izena = "";
	
	public MutexBikoitza(String izena)
	{
		this.izena = izena;
	}
	
	public void gehituc1()
	{
		synchronized(mutex1) {
			GlobalVar.c1++;
			System.out.println(this.izena + " naiz eta GlobalVar.c1 aldagaiari 1 gehitu diot. Orain c1 = " + GlobalVar.c1);
		}
	}
	
	public void kenduc1()
	{
		synchronized(mutex1) {
			GlobalVar.c1--;
			System.out.println(this.izena + " naiz eta GlobalVar.c1 aldagaiari 1 kendu diot. Orain c1 = " + GlobalVar.c1);
		}
	}
	
	public void gehituc2()
	{
		synchronized(mutex2) {
			GlobalVar.c2++;
		    System.out.println(this.izena + " naiz eta GlobalVar.c2 aldagaiari 1 gehitu diot. Orain c2 = " + GlobalVar.c2);
		}
	}
	
	public void kenduc2()
	{
		synchronized(mutex2) {
			GlobalVar.c2--;
			System.out.println(this.izena + " naiz eta GlobalVar.c2 aldagaiari 1 kendu diot. Orain c2 = " + GlobalVar.c2);
		}
	}
	
	
	public void run()
	{
		gehituc1();
		gehituc2();
		kenduc1();
	}
}

