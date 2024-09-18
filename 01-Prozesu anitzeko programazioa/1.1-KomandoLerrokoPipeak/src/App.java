import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Prozesua sortzen...");
            ProcessBuilder pBuilder = new ProcessBuilder("cmd.exe", "/c", "TASKLIST /SVC | findstr svchost.exe");
            Process p = pBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            FileWriter writer = new FileWriter("C:\\Users\\maider\\Desktop\\PAAG2\\ZERBITZU ETA PROZESUEN PROGRAMAZIOA\\01-Prozesu anitzeko programazioa\\1.1-KomandoLerrokoPipeak\\src\\output/svchost.txt");

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line+"\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Errorea: "+e.getMessage());
        } 
    }
    
}
