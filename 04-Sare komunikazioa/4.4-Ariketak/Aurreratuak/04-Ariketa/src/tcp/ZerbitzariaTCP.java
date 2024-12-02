package tcp;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Ikaslea;

public class ZerbitzariaTCP {
    public static void main(String[] args) {
        ServerSocket zerbitzariSocket = null;
        Socket bezeroSocket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            int portua = 12345;
            zerbitzariSocket = new ServerSocket(portua);
            System.out.println("Zerbitzaria martxan dago...");

            bezeroSocket = zerbitzariSocket.accept();
            System.out.println("Bezeroa konektatuta: " + bezeroSocket.getInetAddress() );

            // Bezeroarekin konektatzeko fluxuak
            in = new ObjectInputStream(bezeroSocket.getInputStream());
            out = new ObjectOutputStream(bezeroSocket.getOutputStream());

            // Ikaslea jaso eta id-a esleitu
            Ikaslea ikaslea = (Ikaslea) in.readObject();
            int idBerria = (int) (Math.random() * 1000.0); // id berria esleitu
            ikaslea.setId(idBerria);

            // Ikaslea bidali bezeroari
            out.writeObject(ikaslea);
            System.out.println("Ikaslea bidalita: " + ikaslea);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (bezeroSocket != null) bezeroSocket.close();
                if (zerbitzariSocket != null) zerbitzariSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}