package ro.usv.cutii;

import java.util.Objects;

public class Cilindru implements ICutie {
    private final double r;
    private final double h;

    public Cilindru(double r, double h) {
        this.r = r;
        this.h = h;
    }

    @Override
    public double getSuprafataTotala() {
        return Math.round(2 * Math.PI * r * ( r + h));
    }

    @Override
    public double getLungimePanglica() {
        return Math.round(2 * 2 * Math.PI * r + lnod);
    }

    @Override
    public String toString() {
        return "Cutie - Cilindru" +
                "{r=" + r +
                ", h=" + h +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cilindru cilindru)) return false;
        return Double.compare(cilindru.r, r) == 0 && Double.compare(cilindru.h, h) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, h);
    }

    @Override
    public double pret() {
        return ICutie.super.pret();
    }
}