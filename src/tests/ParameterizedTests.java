package tests;


import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.ase.csie.cts.model.CreditBancar;
import ro.ase.csie.cts.model.Creditor;
import ro.ase.csie.cts.model.Debitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(JUnitParamsRunner.class)
public class ParameterizedTests {

    CreditBancar creditBancar = new CreditBancar();
    Debitor debitor = new Debitor();
    Creditor creditor = new Creditor();


    @Test
    @FileParameters("src/data/DateTest.csv")
    public void testeazaMetodaCalculDobandaSpeciala(double rataDobanda, boolean special, double rataDobandaFinala){
        System.out.print("Rata dobanda standard: " + rataDobanda + " " + " ,Special: " + special);
        creditBancar.setSpecial(special);
        creditBancar.setRataDobanda(rataDobanda);
        System.out.println(" Rata dobanda speciala: "+creditBancar.getRataDobanda());

        assertEquals(rataDobandaFinala, creditBancar.getRataDobanda(), 0);

    }

    @Test
    @FileParameters("src/data/VenitNetDebitor.csv")
    public void testeazaEligibilitateClient(double venit, boolean eligibilitate){
        System.out.println("Venitul testat este: "+venit+" "+"Exista eligibilitate client? R: "+eligibilitate);
        debitor.setVenitNet(venit);
        assertEquals(eligibilitate,  creditor.oferaRapunsInitiereCerere(debitor));


    }
}
