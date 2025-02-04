/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package azterketamaider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author maider
 */
public class ZerbitzariaAlice {

    private static double diruTotala = 0;
    public static void main(String[] args) {
        int port = 12321; // portua definitu
        try(ServerSocket serverSocket = new ServerSocket(port)) { // Zerbitzariaren socket-a hasieratu portuarekin
            System.out.println("Zerbitzaria martxan...");
            while(true) {
                try(Socket clientSocket = serverSocket.accept()) { // Bezeroaren konexioa onartu
                    // Bezeroaren datuak jaso
                    BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message = input.readLine();
                    int receivedNum = Integer.parseInt(message);
                    // BOBek bidalitakoa pantailan imprimatu
                    System.out.println("JASOTAKOA: BOBek bidalitako diru kopurua: " + receivedNum + " euro");
                    
                    // 40(t=80€ biak batera)---- 1 hilabete
                    // 250€ --------- x --> x= 250/40
                    
                    diruTotala += receivedNum;
                    // Bezeroarei erantzuna bidali
                    double zenbatHilabete = receivedNum/40;
                    
                    double soberan = diruTotala-40;
                    PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true);
                    output.println(zenbatHilabete);
                    //output.print(soberan);
                    
                    // Erantzuna egiaztatzeko
                    System.out.println("kalkulua: "+receivedNum + " euro " + zenbatHilabete + " hilabetentzako gastua" + "Soberan" + soberan);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
