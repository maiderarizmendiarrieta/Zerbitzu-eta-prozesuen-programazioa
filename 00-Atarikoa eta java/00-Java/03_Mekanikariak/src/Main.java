import model.HodeiMekanikaria;
import model.MekanikariaException;

public class Main {
    public static void main(String[] args) throws Exception {
        HodeiMekanikaria hm1 = new HodeiMekanikaria();
        
        
        hm1.autoaKonpondu();
        hm1.biharEtorri();
        hm1.kobratu();

        try {
            hm1.autoaKonpondu();
        } catch (MekanikariaException e) {
            e.printStackTrace();
        }
    }
}
