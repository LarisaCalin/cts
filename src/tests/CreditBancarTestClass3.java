package tests;


import org.junit.*;
import ro.ase.csie.cts.patterns.strategy.CalculDobanda;
import ro.ase.csie.cts.patterns.strategy.DobandaCompusa;
import ro.ase.csie.cts.patterns.strategy.DobandaSimpla;
import ro.ase.csie.cts.patterns.strategy.DobandaStrategy;

public class CreditBancarTestClass3 {

    DobandaStrategy dobandaSimpla = null;
    DobandaStrategy dobandaCompusa = null;
    CalculDobanda calculDobanda1 = null;
    CalculDobanda calculDobanda2 = null;
    double valoareCredit;
    double rataDobanda;


    @Before
    public void setUpStrategie() {
        valoareCredit = 10000;
        rataDobanda = 0.2;
        dobandaSimpla = new DobandaSimpla(valoareCredit, rataDobanda);
        dobandaCompusa = new DobandaCompusa(valoareCredit, rataDobanda);
        calculDobanda1 = new CalculDobanda();
        calculDobanda1.setStrategy(dobandaSimpla);
        calculDobanda2 = new CalculDobanda();
        calculDobanda2.setStrategy(dobandaCompusa);

        //alternativ, apoi se seteaza dobandaCompusa, pentru verificare
        //calculDobanda.setStrategy(dobandaCompusa);
    }

    @Test
    public void testeazaMetodaCalculDobanda1(){
        Assert.assertTrue("Metoda de calcul a dobanzii este incorecta (1)", calculDobanda1.calculeazaDobanda() == 2000);
        Assert.assertTrue("Metoda de calcul a dobanzii este incorecta (2)", calculDobanda2.calculeazaDobanda() == 400);
    }



    @After
    public void printUp(){
        if(calculDobanda1.getStrategy() instanceof DobandaSimpla)
            System.out.println("1. S-a folosit metoda de calcul a dobanzii simple");
        if(calculDobanda1.getStrategy() instanceof  DobandaCompusa)
            System.out.println("1. S-a folosit metoda de calcul a dobanzii compuse  ");
        if(calculDobanda2.getStrategy() instanceof DobandaSimpla)
            System.out.println("2. S-a folosit metoda de calcul a dobanzii simple");
        if(calculDobanda2.getStrategy() instanceof  DobandaCompusa)
            System.out.println("2. S-a folosit metoda de calcul a dobanzii compuse  ");

    }
}