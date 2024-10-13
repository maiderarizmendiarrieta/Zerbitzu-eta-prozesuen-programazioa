import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ZorizJaurti {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            ProcessBuilder pb = new ProcessBuilder("java.exe", "Zoriz");
            Process p = pb.start();

            // Prozesuaren sarrera eta irtera
            InputStream stdin = p.getInputStream();
            OutputStream stdout = p.getOutputStream();
            Scanner pScanner = new Scanner(stdin);
            
            while (true) {
                String sarrera = in.nextLine();
            
                // Testua semeari bidali
                stdout.write((sarrera + "\n").getBytes());
                stdout.flush(); // testua bialtzen dala ziurtatzeko

                if (sarrera.equals("buka")) {
                    break;
                }

                // Semeak bidalitako zenbakia irakurtzeko
                String erantzuna = pScanner.nextLine();
                System.out.println(erantzuna);
                
            }
            pScanner.close();
            p.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
