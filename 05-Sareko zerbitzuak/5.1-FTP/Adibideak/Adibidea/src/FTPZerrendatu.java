import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPZerrendatu {
    public static void main(String[] args) {
        String password="123";
        FTPClient ftpClient = new FTPClient();
        
        // Esto hace que se vean por consola los errores
        // ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        
        try {
            ftpClient.connect("127.0.0.1", 21);
            ftpClient.login("Maider", password);
            listDirectory(ftpClient, "/", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listDirectory(FTPClient ftpClient, String dirPath, int level) throws IOException {
        FTPFile[] files = ftpClient.listFiles(dirPath);

        for (FTPFile file : files) {
            // Imprimir sangría para subdirectorios
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            if (file.isDirectory()) {
                System.out.println("[DIR] " + file.getName());
                listDirectory(ftpClient, dirPath + "/" + file.getName(), level + 1);
            } else {
                System.out.println("[FILE] " + file.getName());
            }
        }
    }
} 