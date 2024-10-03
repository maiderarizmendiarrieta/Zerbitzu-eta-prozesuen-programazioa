import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        String izena;
        Scanner in = new Scanner(System.in);
        System.out.print("Sartu izen bat: ");
        izena = in.nextLine();
        in.close();

        try {
            @SuppressWarnings("deprecation")
            Process p = Runtime.getRuntime().exec("cmd /c echo " + izena);
            System.out.println("Prozesua JAURTI da.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String lerroa;

            while ((lerroa = reader.readLine()) != null) {
                System.out.println("Prozesuaren irteera: " + lerroa);
            }

            int exit = p.waitFor();
            System.out.println("Prozesua amaitu da. Irtera-kodea: " + exit);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}