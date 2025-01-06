package paagbi;

import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FTPDeskargatu {
    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        String password="1234";
        try {
            ftpClient.connect("127.0.0.1", 21);
            ftpClient.login("erabiltzailea", password);
            FileOutputStream fileOutputStream = new FileOutputStream("localFile.txt");
            BufferedOutputStream bufferedOutputStream  = new BufferedOutputStream(fileOutputStream);
            if (ftpClient.retrieveFile("remoteFile.txt", bufferedOutputStream)) {
                System.out.println("File downloaded successfully.");
            } else {
                System.out.println("Failed to download the file.");
            }
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}