package ro.ase.csie.cts.patterns.facade;


import ro.ase.csie.cts.model.Creditor;
import ro.ase.csie.cts.model.Debitor;

public class ContracteazaCredit {

    Debitor debitor;
    Creditor creditor;

    public ContracteazaCredit(Debitor debitor, Creditor creditor){

        this.debitor =  debitor;
        this.creditor =  creditor;
    }

    public void contracteazaCredit(){

        this.debitor.initiazaCerereCredit();
        boolean raspuns = this.creditor.oferaRapunsInitiereCerere(this.debitor);

        if(raspuns) {
            this.creditor.instiinteazaAprobareCerere();
            this.debitor.furnizeazaDatePersonale();
            this.debitor.semnareContractCredit();
            this.debitor.incasareSuma();
        }
          else this.creditor.instiinteazaRespingereCerere();



    }
}
