import java.io.IOException;

public class ZorizJaurti {
    public static void main(String[] args) {
        
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Zoriz.java");
            Process p = pb.start();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
