package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class CreditBancarTestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CreditBancarTestClass1.class, CreditBancarTestClass2.class, CreditBancarTestClass3.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("Testele s-au efectuat cu succes? R: "+result.wasSuccessful());
        System.out.println("Teste picate: "+result.getFailureCount());
        System.out.println("Numar total de teste: "+result.getRunCount());
    }
}
