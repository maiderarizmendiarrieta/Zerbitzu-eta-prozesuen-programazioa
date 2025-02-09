/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg06;

/**
 *
 * @author maider
 */
public class Main {

    public static void main(String[] args) {
        Ilara ilara = new Ilara(10);
        Kontsumitzailea kontsumitzailea = new Kontsumitzailea(ilara);
        Ekoizlea ekoizlea = new Ekoizlea(ilara);
        
        ekoizlea.start();
        kontsumitzailea.start();
    }
    
}
