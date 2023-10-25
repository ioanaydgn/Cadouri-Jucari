package ro.usv.jucarii;

import ro.usv.cutii.TipCutie;

public class Avion extends Jucarie {
    public Avion(double l1, double l2, double l3) {
        super(l1, l2, l3);
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.PARALELIPIPED;
    }

    @Override
    public double getPret() {
        return 100;
    }

    @Override
    public String toString() {
        StringBuilder string;
        int i = 1;
        string = new StringBuilder("{" + getClass().getSimpleName() + ", cutie recomandata:" + getTipCutie());
        double[] dim = getDimensiuni();
        for(Double val : dim)
        {
            string.append(", l");
            string.append(i).append("=").append(val);
            i++;
        }
        string.append("}");
        return string.toString();
    }
}