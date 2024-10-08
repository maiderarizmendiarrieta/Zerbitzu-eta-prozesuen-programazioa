import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.io.*;
import java.util.regex.*;

public class FitxategiGuztienBatura {
    
    public static void main(String[] args) {
        // Fitxategiak
        String[] fitxategiak = {"informatika.txt", 
                                "mekanika.txt", 
                                "elektronika.txt", 
                                "automozioa.txt",
                                "administrazioa.txt"}; // Fitxategi hau ez da existitzen
        

        System.out.println("FITXATEGI GUZTIEN BATURA HASTERA DOA!!!\n");

        // Executor zerbitzua, fitxategi bakoitza paraleloan prozesatzeko
    }
}

class FileReaderTask implements Runnable {
    private String filePath;

    public FileReaderTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try {
            String[] agindua = {"cmd.exe", "/c", "type", filePath};
            Process p = Runtime.getRuntime().exec(agindua);

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String lerroa;
            Pattern pattern = Pattern.compile("\\d");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
