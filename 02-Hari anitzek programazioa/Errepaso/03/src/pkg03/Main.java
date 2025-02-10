/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg03;

/**
 *
 * @author maider
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        //for (int ronda = 1; ronda <= 3; ronda++) {
            KarreraC karrera = new KarreraC();
            for (int c = 1; c <= 8; c++) {
                KorrikalariaC k = new KorrikalariaC(c, karrera);
                k.start();
            }
        //}

        System.out.println("\n--- Karrera amaitu da ---");
    }
    
}
