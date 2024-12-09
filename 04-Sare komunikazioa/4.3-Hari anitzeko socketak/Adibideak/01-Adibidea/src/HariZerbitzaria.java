import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class HariZerbitzaria extends Thread {
    PrintWriter irteeraFluxua;
	Socket socket = null;
	
	public HariZerbitzaria(Socket s)
	{
		this.socket = s;
		
		try {
			// Sarrera eta irteerako fluxuak sortzen dira
			irteeraFluxua = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
	//PROZESU UMEA:
		String bidaltzekoTestua = "Kaixo, bezero!";

		System.out.println("HariZerbitzari-" + Thread.currentThread().getName() + ": eskaera prozesatzen...");

		//BEZEROARI ZERBITZUA EMAN
		irteeraFluxua.println(bidaltzekoTestua); 
		irteeraFluxua.flush();

		//prozesatzen denbora luzea behar lukeenaren antzezpena
		try {
			Thread.sleep(20000); 
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		//PROZESUAREN AMAIERA
		System.out.println("HariZerbitzari-" + Thread.currentThread().getName() + ": bezeroarekin komunikazioa bukatu da: " + this.socket.toString());
		try {
			irteeraFluxua.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
