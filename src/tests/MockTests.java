package tests;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ro.ase.csie.cts.model.CreditBancar;
import ro.ase.csie.cts.patterns.builder.CreditBancarBuilder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTests {


    CreditBancar credit;

    @Mock
    CreditBancarBuilder builder;
    double valoareCredit;


    @Before
    public void prepareDependencies() {
        MockitoAnnotations.initMocks(this);
        valoareCredit = 20000;
        credit =  builder.build();
    }

    @Test
     public void testeazaCreditBuilder(){
     when(builder.setValoareCredit(valoareCredit)).thenReturn(builder);
    }


    @Test
    public void testeazaMetodaBuildCreditBancar() {
       when(builder.build()).thenReturn(credit);
    }

}
