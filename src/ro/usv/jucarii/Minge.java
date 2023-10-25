package ro.usv.jucarii;

import ro.usv.cutii.TipCutie;

public class Minge extends Jucarie {

    public Minge(double l1) {
        super(l1, 0, 0);
    }

    @Override
    public TipCutie getTipCutie() {
        return TipCutie.CUB;
    }

    @Override
    public double getPret() {
        return 50;
    }

    @Override
    public String toString() {
        String string;
        string = "{" + getClass().getSimpleName() + ", cutie recomandata:" + getTipCutie() + ", l1=";
        double[] dim = getDimensiuni();
        string += dim[0];
        string += "}";
        return string;
    }
}