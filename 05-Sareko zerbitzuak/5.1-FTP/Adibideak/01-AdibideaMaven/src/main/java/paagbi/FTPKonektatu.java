package paagbi;

import org.apache.commons.net.ftp.FTPClient;

public class FTPKonektatu {
    public static void main(String[] args) {
        FTPClient ftpClient = new FTPClient();
        String password="Admin123";
        try {
            ftpClient.connect("127.0.0.1", 21);
            ftpClient.login("Maider", password);
            System.out.println("Connected to FTP server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}