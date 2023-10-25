package ro.usv.magazin;

import ro.usv.cutii.ICutie;

public class RolaPanglica {
    private static RolaPanglica inst = null;
    double disponibil = 10000;
    private static final double costUnitateLungime = 0.01;

    public static RolaPanglica getRola(){
        if(inst == null)
            inst = new RolaPanglica();
        return inst;
    }

    public double cumpara(double l){
        if(disponibil < l)
            Aprovizionare(10000);

        disponibil -= l;
        return l;
    }

    public double getDisponibil() {
        return disponibil;
    }

    public void Aprovizionare(double l)
    {
        System.out.println("Rola noua");
        disponibil += l;
    }

    public static double getPret(ICutie cutie)
    {
        return cutie.getLungimePanglica() * costUnitateLungime;
    }

}