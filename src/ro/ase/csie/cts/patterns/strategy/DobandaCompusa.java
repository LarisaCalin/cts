package ro.ase.csie.cts.patterns.strategy;


public class DobandaCompusa extends DobandaStrategy {


    public DobandaCompusa(double valoareCredit, double rataDobanda){
        super(valoareCredit, rataDobanda);
    }


    @Override
    public double calculeazaDobanda() {
        return  this.valoareCredit*this.rataDobanda*this.rataDobanda;
    } //rata dobanda 2 ori
}
