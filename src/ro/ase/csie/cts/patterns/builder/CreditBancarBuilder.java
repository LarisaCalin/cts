package ro.ase.csie.cts.patterns.builder;

import ro.ase.csie.cts.exceptions.DurataContractareCreditNenegativa;
import ro.ase.csie.cts.model.CreditBancar;
import ro.ase.csie.cts.model.Creditor;
import ro.ase.csie.cts.model.Debitor;

import java.util.Date;


public class CreditBancarBuilder {

    private CreditBancar creditBancar;

    public CreditBancarBuilder(){
        this.creditBancar = new CreditBancar();
    }

    public CreditBancarBuilder setValoareCredit(double valoare){
        this.creditBancar.setValoare(valoare);
        return this;
    }

    public CreditBancarBuilder setDataContractare(Date date){
        this.creditBancar.setDataContractare(date);
        return this;
    }

    public CreditBancarBuilder setDebitor(Debitor debitor){
        this.creditBancar.setDebitor(debitor);
        return this;
    }

    public CreditBancarBuilder setCreditor(Creditor creditor){
        this.creditBancar.setCreditor(creditor);
        return this;
    }

    public CreditBancarBuilder setDurataContractare(int durata){
        try {
            this.creditBancar.setDurataContractare(durata);
        } catch (DurataContractareCreditNenegativa durataContractareCreditNenegativa) {
            durataContractareCreditNenegativa.printStackTrace();
        }
        return this;
    }

    public CreditBancarBuilder setTipDobanda(String tipDobanda){
        this.creditBancar.setTipDobanda(tipDobanda);
        return this;
    }

    public CreditBancarBuilder setSpecial(boolean special){
        this.creditBancar.setSpecial(special);
        return this;
    }

    public CreditBancarBuilder setRataDobanda(double rata){
        this.creditBancar.setRataDobanda(rata);
        return this;
    }

    public CreditBancarBuilder setMoneda(String moneda){
        this.creditBancar.setMoneda(moneda);
        return this;
    }

    public CreditBancarBuilder setUnitateDurata(String unitate){
        this.creditBancar.setUnitateDurataContractare(unitate);
        return this;
    }
    public CreditBancar build(){
        return this.creditBancar;
    }
}
