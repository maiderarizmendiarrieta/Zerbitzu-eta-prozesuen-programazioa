public class MutualExclusion {

	public static void main(String[] args) throws InterruptedException {
		int hari_kopurua = 10000;//50000;
		
		MutexBikoitza hariak[];
		System.out.println(hari_kopurua + " hari sortzen...");	
		// Harien Array-a hasieratzen dugu
		hariak = new MutexBikoitza[hari_kopurua];
		// Hariak banan banan sortzen ditugu
		for (int i=0; i<hari_kopurua; i++)
		{
			String izena = "Haria_" + i;
			hariak[i] = new MutexBikoitza(izena);
		}		
		// Hariak banan banan lanean jartzen ditugu
		for (int i=0; i<hari_kopurua; i++)
		{
			hariak[i].start();
		}
		//Hari guztiak bukatu arte ez gara irtetzen
		for (int i=0; i<hari_kopurua; i++)
		{
			hariak[i].join();
		}
		// Azkenik, aldagaien balioak erakusten ditugu
		System.out.println("MutualExclusion hari nagusia naiz.");
		System.out.println("GlobalVar.c1 = " + GlobalVar.c1);
		System.out.println("GlobalVar.c2 = " + GlobalVar.c2);
	}
}