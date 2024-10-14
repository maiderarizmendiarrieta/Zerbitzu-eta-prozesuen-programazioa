import java.util.Scanner;

public class Zoriz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String lerroa;
        while ((lerroa = in.nextLine()) != null) {

            if (lerroa.equals("buka")) {
                break;
            }
            System.out.println((int) (Math.random() * 11));
        }
        in.close();
    }
}
