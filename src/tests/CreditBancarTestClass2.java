package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.ase.csie.cts.model.CreditBancar;

import static org.junit.Assert.assertEquals;

public class CreditBancarTestClass2 {

    CreditBancar credit = new CreditBancar();

    @Before
    public void setUp(){
        credit.setValoare(4000);
        credit.setSpecial(true);
        credit.setRataDobanda(0.3);
    }

    @Test
    public void testeazaValoareDobanda(){

        double valoare = credit.getValoare()*credit.getRataDobanda();
        assertEquals(360, valoare, 0);
    }

    @After
    public void printAfter(){
        if( credit.getValoare()*credit.getRataDobanda() == 800)
            System.out.println("Rata dobanzii este calculata corect in conditii speciale");
        else  System.out.println("Rata dobanzii NU este calculata corect in conditii speciale");
    }
}
