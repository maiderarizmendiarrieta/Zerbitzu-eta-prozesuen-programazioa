import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException{
        try {

            ProcessBuilder pBuilder = new ProcessBuilder("echo Kaixo mundua");
            Process p = pBuilder.start();
            InputStream in = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null ) {
                System.out.println("Seme-prozesuak bueltatu du: " + line);
            }
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
