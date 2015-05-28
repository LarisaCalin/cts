package ro.ase.csie.cts.model;


public class Debitor {

    private String nume;
    private double venitNet;
    private String adresa;
    private String telefon;

    public Debitor(){
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getVenitNet() {
        return venitNet;
    }

    public void setVenitNet(double venitNet) {
        this.venitNet = venitNet;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return nume;
    }

    public void initiazaCerereCredit(){
        System.out.println("Cererea de obtinere a creditului a fost initiata");
    }

    public void furnizeazaDatePersonale(){
        System.out.println("Utilizatorul a furnizat datele personale: \n"
                +this.getNume()+"\n"
                +"Adresa: "+this.getAdresa()+"\n"
                +"Telefon: "+this.getTelefon());
    }

    public void semnareContractCredit(){
        System.out.println("Utilizatorul a semnat contractul");
    }

    public void incasareSuma(){
        System.out.println("Utilizatorul a incasat suma");
    }


}
