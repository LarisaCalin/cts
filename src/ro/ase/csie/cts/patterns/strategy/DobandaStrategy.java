package ro.ase.csie.cts.patterns.strategy;


public abstract class DobandaStrategy {
    protected double valoareCredit;
    protected double rataDobanda;

    public DobandaStrategy(double valoareCredit, double rataDobanda){
        this.valoareCredit = valoareCredit;
        this.rataDobanda = rataDobanda;
    }
    public abstract double calculeazaDobanda();
}
