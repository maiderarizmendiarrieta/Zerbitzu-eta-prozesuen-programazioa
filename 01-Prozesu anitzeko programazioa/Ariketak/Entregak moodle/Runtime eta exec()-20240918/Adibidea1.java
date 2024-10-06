package unieibar;

public class Adibidea1 { 
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime(); 
        String comando= "NOTEPAD"; 
        Process p; 
        try {
            p = r.exec(comando); 
            System.out.println("Semea martxan "+p.pid()+" zenbakiarekin.");
        } 
        catch (Exception e) { 
            System.out.println("Error en: "+comando); 
            e.printStackTrace(); 
        } 
    }
}
//Adibidea Windowsen agindu-lerroko agindua exekutatzeko 
//harien bidez eta Runtime/exec erabilita
    