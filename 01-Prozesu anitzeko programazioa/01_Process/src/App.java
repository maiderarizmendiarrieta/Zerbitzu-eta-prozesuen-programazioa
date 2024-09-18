import java.io.InputStream;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            System.out.println("Process-a sortzen...");
            String[] cmd = {"notepad.exe"};
            Process p = Runtime.getRuntime().exec(cmd);

            InputStream in = p.getInputStream();
            for (int i = 0; i < in.available(); i++) {
                System.out.println("" + in.read());
            }

            Thread.sleep(1000);
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
