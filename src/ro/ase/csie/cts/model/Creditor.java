package ro.ase.csie.cts.model;


public class Creditor {

    private String denumire;
    private String adresa;

    public Creditor() {
    }

    public Creditor(String denumire, String adresa){
        this.denumire = denumire;
        this.adresa = adresa;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }



    @Override
    public String toString() {
        return "Creditor "+denumire;
    }

    public boolean respingeCerere(Debitor debitor){
        return false;
    }

    public void instiinteazaAprobareCerere(){
        System.out.println("Suntem bucurosi sa va anuntam ca cerera dvs. a fost aprobata!");
    }

    public void instiinteazaRespingereCerere(){
        System.out.println("Ne pare rau, dar nu sunteti eligibil pentru acordarea creditului!");
    }

    public boolean aprobaCerere(Debitor debitor){
        return true;
    }

    public boolean oferaRapunsInitiereCerere(Debitor debitor){

        if(debitor.getVenitNet() >= 3000)
            return aprobaCerere(debitor);
        else return respingeCerere(debitor);
    }
}
