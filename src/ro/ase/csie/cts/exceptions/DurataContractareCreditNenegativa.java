package ro.ase.csie.cts.exceptions;


public class DurataContractareCreditNenegativa extends Exception {;

    public DurataContractareCreditNenegativa(){
        super("Perioada de contractare a creditului trebuie sa fie o valoare mai mare decat 0");
    }
}
