package ro.ase.csie.cts.patterns.strategy;


public class DobandaSimpla extends DobandaStrategy {


    public DobandaSimpla(double valoareCredit, double rataDobanda){
        super(valoareCredit, rataDobanda);
    }

    @Override
    public double calculeazaDobanda() {
        return this.valoareCredit*this.rataDobanda;
    }
}
