package ro.usv.cutii;

public interface ICutie {
    double pretUnitateDeSuprafata = 0.05;
    double lnod=20;

    double getSuprafataTotala();
    double getLungimePanglica();

    default double pret(){
        return getSuprafataTotala()*pretUnitateDeSuprafata;
    }
}