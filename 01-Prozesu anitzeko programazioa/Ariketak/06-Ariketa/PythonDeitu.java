import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythonDeitu {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python3", "kaixoMundua.py");
            Process p = pb.start();
            System.out.println("Prozesua JAURTI da.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String emaitza = reader.readLine();
            System.out.println("Python programaren emaitza: " + emaitza);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}