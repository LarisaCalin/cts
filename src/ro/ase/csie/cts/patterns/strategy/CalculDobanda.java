package ro.ase.csie.cts.patterns.strategy;


public class CalculDobanda {

    private DobandaStrategy strategy = null;
    private double valoareCredit;
    private double rataDobanda;

    public DobandaStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(DobandaStrategy strategy) {
        this.strategy = strategy;
    }

    public double getValoareCredit() {
        return valoareCredit;
    }

    public void setValoareCredit(double valoareCredit) {
        this.valoareCredit = valoareCredit;
    }

    public double getRataDobanda() {
        return rataDobanda;
    }

    public void setRataDobanda(double rataDobanda) {
        this.rataDobanda = rataDobanda;
    }

    public double calculeazaDobanda(){
        double dobanda = -1;
        if(this.strategy!=null)
           dobanda =  strategy.calculeazaDobanda();
        return dobanda;
    }
}
