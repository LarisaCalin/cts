package ro.ase.csie.cts.main;


import ro.ase.csie.cts.model.CreditBancar;
import ro.ase.csie.cts.model.Creditor;
import ro.ase.csie.cts.model.Debitor;
import ro.ase.csie.cts.patterns.builder.CreditBancarBuilder;
import ro.ase.csie.cts.patterns.facade.ContracteazaCredit;
import ro.ase.csie.cts.patterns.strategy.CalculDobanda;
import ro.ase.csie.cts.patterns.strategy.DobandaCompusa;
import ro.ase.csie.cts.patterns.strategy.DobandaSimpla;
import ro.ase.csie.cts.patterns.strategy.DobandaStrategy;
import ro.ase.csie.cts.utils.Dobanda;
import ro.ase.csie.cts.utils.UnitateContractare;
import ro.ase.csie.cts.utils.Utils;

import java.util.Date;

public class Main {

    public static void main(String [] args){

        System.out.println("-----------BUILDER PATTERN TESTING------------");

        Date dataContractare = Utils.convertStringToDate("25.05.2014");

        Creditor creditor = new Creditor("BCR", "Bld Victoriei, nr. 115-117");
        Debitor debitor = new Debitor();
        debitor.setNume("Larisa Calin");
        debitor.setAdresa("Str. Independentei, nr. 14, Sector 1, Bucuresti");
        debitor.setVenitNet(4000);
        debitor.setTelefon("0740210433");

        CreditBancar creditBancar1 = new CreditBancarBuilder()
                                      .setValoareCredit(20000)
                                        .setMoneda("RON")
                                         .setDataContractare(dataContractare)
                                          .setDurataContractare(5)
                                           .setUnitateDurata(UnitateContractare.ANI)
                                             .setCreditor(creditor)
                                              .setDebitor(debitor)
                                               .setTipDobanda(Dobanda.DOBANDA_SIMPLA)
                                                 .setSpecial(true)
                                                  .setRataDobanda(0.3)
                                                    .build();

        System.out.println(creditBancar1);
        System.out.println("-----------FACADE PATTERN TESTING------------");



        //FACADE PATTERN

        ContracteazaCredit contracteazaCreditClass = new ContracteazaCredit(debitor, creditor);
        contracteazaCreditClass.contracteazaCredit();



        System.out.println("-----------STRATEGY PATTERN TESTING------------");

        DobandaStrategy dobandaSimpla =  new DobandaSimpla(1000, 0.2);
        DobandaStrategy dobandaCompusa =  new DobandaCompusa(1000, 0.2);
        CalculDobanda calculeazaDobanda = new CalculDobanda();

        calculeazaDobanda.setStrategy(dobandaSimpla);
        double dobanda1 = calculeazaDobanda.calculeazaDobanda();
        System.out.println("Valoare dobanda prin metoda dobanda simpla "+dobanda1);

        calculeazaDobanda.setStrategy(dobandaCompusa);
        double dobanda2 = calculeazaDobanda.calculeazaDobanda();
        System.out.println("Valoare dobanda prin metoda dobanda compusa "+dobanda2);




    }
}
