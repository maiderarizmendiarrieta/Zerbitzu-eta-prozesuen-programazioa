/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketamaider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author maider
 */
public class BezeroaBob {

    public static void main(String[] args) {
        int port = 12321; // Portua definitu
        Random random = new Random(); // Bidalitako diru kopurua ausaz gertatzeko
        try(Socket socket = new Socket("127.0.0.1", port)) { // Socketa sortu ip helbide zuzenarekin eta portuarekin
            int n = random.nextInt(0,251); // Diru kopurua ausaz 0 eta 250 artean
            
            // Zerbitzariari datuak bidali
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println(n);
            // Bidalitakoa egiaztatzeko
            System.out.println(n + " euro");
            
            // Zerbitzaritik erantzuna jaso
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String erantzuna = input.readLine();
            double nErantzuna = Double.parseDouble(erantzuna);
            
            System.out.println("ERANTZUNA: ALICEk: " + nErantzuna + " hilabetentzako gastua. Soberan: ");
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}                    