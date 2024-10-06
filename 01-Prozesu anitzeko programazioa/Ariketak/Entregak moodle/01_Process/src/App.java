import java.io.InputStream;

public class App {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {

        // LEHENENGO MODUA
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

        // BIGARREN MODUA
        Runtime r = Runtime.getRuntime(); 
        String komandoa= "NOTEPAD"; 
        Process p; 
        try {
            p = r.exec(komandoa); 
            System.out.println("Semea martxan "+p.pid()+" zenbakiarekin.");
        } 
        catch (Exception e) { 
            System.out.println("Akatsa: "+komandoa); 
            e.printStackTrace(); 
        } 
        // Adibidea Windowsen agindu-lerroko agindua exekutatzeko 
        // Runtime/exec erabilita
    }
}
