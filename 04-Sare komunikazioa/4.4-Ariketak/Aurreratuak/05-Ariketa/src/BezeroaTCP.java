import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BezeroaTCP {
    public static void main(String[] args) {
        String helbidea = "localhost";
        int portua = 12345;

        System.out.println("Bezeroa martxan...");
        Scanner scanner = new Scanner(System.in);
        int aukera = 0;
        
        switch (aukera) {
            case 1:
                
                break;
        
            default:
                break;
        }
        try (Socket bezeroa = new Socket(helbidea, portua)) {

            // Bezeroaren irteera fluxua zerbitzariari mezuak bidaltzeko
            OutputStream out = bezeroa.getOutputStream();
            PrintWriter printOut = new PrintWriter(out, true);

            // Bezeroaren sarrera fluxua zerbitzaritik mezuak irakurtzeko
            InputStream in = bezeroa.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
