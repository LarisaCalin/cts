package tests;


import org.junit.*;
import ro.ase.csie.cts.exceptions.DurataContractareCreditNenegativa;
import ro.ase.csie.cts.model.CreditBancar;
import ro.ase.csie.cts.utils.Utils;

import java.util.Date;

import static org.junit.Assert.*;

public class CreditBancarTestClass1 {

   static  CreditBancar credit = new CreditBancar();

    @BeforeClass
    public static void setUp(){
        credit.setValoare(40000);
        credit.setRataDobanda(0.3);
        credit.setDataContractare(Utils.convertStringToDate("23.10.2014"));
        try {
            credit.setDurataContractare(5);
        } catch (DurataContractareCreditNenegativa durataContractareCreditNenegativa) {
            durataContractareCreditNenegativa.printStackTrace();
        }

    }

    @Test
    public void testeazaValoareDobanda(){

        double valoare = credit.getValoare()*credit.getRataDobanda();
        assertEquals(12000, valoare, 0);
    }

    @Test
    public void testeazaValidareDurataNenegativa(){

        try {
            credit.setDurataContractare(-12);
            fail("Durata de contractare accepta si valori negative");
        } catch (DurataContractareCreditNenegativa durataContractareCreditNenegativa) {
            durataContractareCreditNenegativa.printStackTrace();
        }
    }



    //@Ignore --> se decomenteaza pentru a demonstra rolul adnotatiei "@Ignore" . Acesta adnotatie face ca testul sa nu fie executat.
    @Test
    public void testeazaFormatareData1(){
        Date data = credit.getDataContractare();
        String formatStringDate = Utils.formatDate(data);
        assertFalse("Formatarea NU s-a realizat cu succes!", formatStringDate.equals("23 11 2014"));
    }

    @Test
    public void testeazaFormatareData2(){
        Date data = credit.getDataContractare();
        String formatStringDate = Utils.formatDate(data);
        assertTrue("Formatarea NU s-a realizat cu succes!", formatStringDate.equals("23 10 2014"));
    }



    @Test()
    public void calculAmortizare(){
        Double amortizare = credit.calculeazaAmortizare();
        assertTrue("Amortizarea nu s-a putut calcula", amortizare == 8000);

    }

    @AfterClass
    public static void printAfter(){
        if( credit.getValoare()*credit.getRataDobanda() == 12000)
            System.out.println("Rata dobanzii este calculata corect in conditii normale");
        else  System.out.println("Rata dobanzii NU este calculata corect in conditii normale");


    }
}
