package ro.ase.csie.cts.model;


import ro.ase.csie.cts.exceptions.DurataContractareCreditNenegativa;
import ro.ase.csie.cts.utils.Utils;

import java.util.Date;

public class CreditBancar {

    private double valoare;
    private Date dataContractare;
    private Debitor debitor;
    private Creditor creditor;
    private int durataContractare;
    private String tipDobanda;
    private boolean special; //daca cel care contracteaza creditul primeste salariul in cont aferent creditorului, atunci beneficiaza de o rata speciala a dobanzii
    private double rataDobanda;
    private String moneda;
    private String unitateDurataContractare;

    public CreditBancar() {
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public Date getDataContractare() {
        return dataContractare;
    }

    public void setDataContractare(Date dataContractare) {
        this.dataContractare = dataContractare;
    }

    public Debitor getDebitor() {
        return debitor;
    }

    public void setDebitor(Debitor debitor) {
        this.debitor = debitor;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public int getDurataContractare() {
        return durataContractare;
    }

    public void setDurataContractare(int durataContractare) throws DurataContractareCreditNenegativa {
        if(durataContractare <= 0)
             throw new DurataContractareCreditNenegativa();
            this.durataContractare = durataContractare;
    }

    public String getTipDobanda() {
        return tipDobanda;
    }

    public void setTipDobanda(String tipDobanda) {
        this.tipDobanda = tipDobanda;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public double getRataDobanda() {
        return rataDobanda;
    }

    public void setRataDobanda(double rataDobanda) {
        if(this.isSpecial()) {
            this.rataDobanda = Math.floor(rataDobanda * rataDobanda * 100) / 100;
            System.out.println(this.rataDobanda);
        }
        else this.rataDobanda = rataDobanda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getUnitateDurataContractare() {
        return unitateDurataContractare;
    }

    public void setUnitateDurataContractare(String unitateDurataContractare) {
        this.unitateDurataContractare = unitateDurataContractare;
    }

    public double calculeazaAmortizare(){
        //System.out.println(this.getValoare());
        //System.out.println(this.getDurataContractare());

        double val = this.getValoare() / this.getDurataContractare();
        return val;
    }





    @Override
    public String toString() {
        return "Credit: "+"\n"
                +"Debitor: "+debitor.toString()+"\n"
                +"Creditor: "+creditor.toString()+"\n"
                +"Valoare: "+valoare+" "
                +moneda+"\n"
                +"Durata contractare: "+durataContractare+" "
                +unitateDurataContractare+"\n"
                +"Data contractare: "+ Utils.formatDate(dataContractare)+"\n"
                +"Tip dobanda: "+tipDobanda+"\n"
                +"Rata dobanda: "+rataDobanda+"\n"
                +"Client special: "+special+"\n"
                +"Rata dobanda: "+rataDobanda;
    }
}
