import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SvchostMain {
    public static void main(String[] args) {
        
        ProcessBuilder pb = new ProcessBuilder();
        pb.command("cmd.exe", "tasklist /svc | findstr svchost.exe");

        try {
            Process p = pb.start();
            System.out.println("Prozesua jaurti da.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String lerroa;
            List<String> svchostList = new ArrayList<>();

            while ((lerroa = reader.readLine()) != null) {
                svchostList.add(lerroa);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("svchost.txt"))) {
                for (String pLerroa : svchostList) {
                    writer.write(pLerroa);
                    writer.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            int exit = p.waitFor();
            if (exit == 0) {
                System.out.println("Prozesuaren azpiprozesuak svchost.txt fitxategian gorde dira.");
            } else {
                System.out.println("Prozesua exekutatzeko heinean errore bat gertatu da.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}