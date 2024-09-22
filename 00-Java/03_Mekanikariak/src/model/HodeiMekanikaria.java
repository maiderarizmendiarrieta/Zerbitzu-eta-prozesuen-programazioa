package model;

public class HodeiMekanikaria implements IMekanikaria{

    public void autoaKonpondu() throws MekanikariaException{
        throw new MekanikariaException("Fluidoen-ihesak daude", "Fluido-ihesak: Aparkatu duzun lurrean orbanak antzeman ditzakezu.");
        
    }

    public int kobratu(){
        return 2500 ;
    }

    public void biharEtorri(){
        System.out.println("Lanpetuta nago, bihar etorri mesedez");
    }
}
