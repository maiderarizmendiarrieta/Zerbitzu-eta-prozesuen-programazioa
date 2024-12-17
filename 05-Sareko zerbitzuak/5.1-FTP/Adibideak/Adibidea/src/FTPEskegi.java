import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;

public class FTPEskegi {
    public static void main(String[] args) {
        String password="pasahitza";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("127.0.0.1", 21);
            ftpClient.login("erabiltzailea", password);
            //take into account where is placed file2FTP.txt
            FileInputStream fileInputStream = new FileInputStream("file2FTP.txt");
            //you can choose different name for the file uploaded if you want
            ftpClient.storeFile("file2FTP.txt", fileInputStream);
            fileInputStream.close();
            System.out.println("File uploaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}