package paagbi;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPZerrendatu {
    public static void main(String[] args) {
        String password="123";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("127.0.0.1", 21);
            System.out.println(ftpClient.login("Maider", "123"));
            
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                System.out.println(file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 