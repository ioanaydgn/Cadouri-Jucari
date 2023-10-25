package ro.usv.magazin;

import ro.usv.cutii.ICutie;
import ro.usv.jucarii.Jucarie;
import ro.usv.jucarii.Minge;

import java.util.Objects;

public class Pachet {
    Jucarie jucarie;
    ICutie cutie;
    double lungPanglica;

    public Pachet(Jucarie jucarie, boolean cereCutie, boolean cerePanglica) {
        this.jucarie = jucarie;
        if(cereCutie)
        {
            cutie = FabricaCutii.getCutie(jucarie);
            if (cerePanglica)
                lungPanglica = RolaPanglica.getRola().cumpara(cutie.getLungimePanglica());
        }
    }

    public double pretPachet() {
        return jucarie.getPret() + (cutie != null ? cutie.pret() : 0) + (lungPanglica > 0 ? RolaPanglica.getPret(Objects.requireNonNull(cutie)) : 0);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(cutie != null )
        {
            stringBuilder.append(", impachetat in ").append(cutie);
            if(lungPanglica > 0)
            {
                stringBuilder.append(", lungPanglica=").append(lungPanglica).append("}");
            }
        }

        return "Pachet{" +
                "jucarie=" + jucarie + stringBuilder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pachet pachet)) return false;
        return Double.compare(pachet.lungPanglica, lungPanglica) == 0 && jucarie.equals(pachet.jucarie) && (cutie == null || cutie.equals(pachet.cutie));
    }

    @Override
    public int hashCode() {
        return Objects.hash(jucarie, cutie, lungPanglica);
    }

    public static void main(String[] args) {
        System.out.println("\n===== Demo Pachet (1p) =====");
        Pachet p1 = new Pachet(new Minge(10), true, true);
        System.out.println(p1);
        System.out.println("Pret="+p1.pretPachet());
    }


}