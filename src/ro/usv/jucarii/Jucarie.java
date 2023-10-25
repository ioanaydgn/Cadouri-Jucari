package ro.usv.jucarii;

import ro.usv.cutii.TipCutie;

import java.util.Arrays;

public abstract class Jucarie {
    private final double[] dimensiuni = new double[3];
    public abstract TipCutie getTipCutie();
    public abstract double getPret();
    public Jucarie(double l1, double l2, double l3) {
        this.dimensiuni[0] = l1;
        this.dimensiuni[1] = l2;
        this.dimensiuni[2] = l3;
    }
    public double[] getDimensiuni() {
        return dimensiuni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jucarie jucarie)) return false;
        return Arrays.equals(getDimensiuni(), jucarie.getDimensiuni()) && jucarie.getTipCutie().equals(this.getTipCutie());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getDimensiuni());
    }
}