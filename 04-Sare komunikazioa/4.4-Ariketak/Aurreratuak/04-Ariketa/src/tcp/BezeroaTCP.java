package tcp;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Ikaslea;

public class BezeroaTCP {
    public static void main(String[] args) {
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        try {
            String zerbitzariHelbidea = "127.0.0.1";
            int zerbitzariPortua = 12345;

            socket = new Socket(zerbitzariHelbidea, zerbitzariPortua);

            // Bezeroarekin komunikatzeko fluxuak
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

            // Ikaslea sortu eta bidali
            Ikaslea ikaslea = new Ikaslea("Jon", 17, 2.5f);
            out.writeObject(ikaslea);
            System.out.println("Ikaslea bidali da: " + ikaslea);

            // Zerbitzariaren erantzuna jaso
            Ikaslea erantzuna = (Ikaslea) in.readObject();
            System.out.println("Erantzuna jaso: " + erantzuna);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
