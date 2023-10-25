package ro.usv.cutii;

import java.util.Objects;

public class Paralelipiped implements ICutie {
    private final double l;
    private final double L;
    private final double h;

    public Paralelipiped(double l, double l1, double h) {
        this.l = l;
        this.L = l1;
        this.h = h;
    }

    @Override
    public double getSuprafataTotala() {
        return 2 * l * L + 2 * L * h + 2 * l * h;
    }

    @Override
    public double getLungimePanglica() {
        return (2 * (L + h) + 2 * (l + L)) + lnod;
    }

    @Override
    public String toString() {
        return "Cutie - " + this.getClass().getSimpleName() +
                (this.getClass().getSimpleName().equals("Paralelipiped") ? ( "{l=" + l +
                        ", L=" + L +
                        ", h=" + h +
                        '}') : ( "{l=" + l + '}'));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paralelipiped that)) return false;
        return Double.compare(that.l, l) == 0 && Double.compare(that.L, L) == 0 && Double.compare(that.h, h) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, L, h);
    }

    @Override
    public double pret() {
        return ICutie.super.pret();
    }
}