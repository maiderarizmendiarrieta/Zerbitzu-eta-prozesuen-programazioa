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

        try (Socket bezeroa = new Socket(helbidea, portua)) {

            // Bezeroaren irteera fluxua zerbitzariari mezuak bidaltzeko
            OutputStream out = bezeroa.getOutputStream();
            PrintWriter printOut = new PrintWriter(out, true);

            // Bezeroaren sarrera fluxua zerbitzaritik mezuak irakurtzeko
            InputStream in = bezeroa.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            try (Scanner scanner = new Scanner(System.in)) {
                boolean jarraitu = true;

                while (jarraitu) {
                    // Zerbitzaritik menua irakurri eta erakutsi
                    String serverResponse;
                    while (!(serverResponse = reader.readLine()).equals("Sartu aukera bat:")) {
                        System.out.println(serverResponse);
                    }
                    System.out.print("Sartu aukera bat: ");

                    // Zerbitzariari bezeroaren aukera bidali
                    String aukera = scanner.nextLine();
                    printOut.println(aukera);

                    // Zerbitzariaren erantzuna erakutsi
                    String erantzuna = reader.readLine();
                    System.out.println("Zerbitzaria: " + erantzuna);

                    // 0 baldin bada aplikazioatik irten eta bukatu
                    if ("0".equals(aukera)) {
                        jarraitu = false;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
