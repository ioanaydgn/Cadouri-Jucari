package ro.usv.jucarii;

import ro.usv.cutii.TipCutie;
public class Racheta extends Jucarie {
    public Racheta(double l1, double l2) {
        super(l1, l2, 0);
    }

        @Override
        public TipCutie getTipCutie() {
            return TipCutie.CILINDRU;
        }

        @Override
        public double getPret() {
            return 120;
        }

        @Override
        public String toString() {
            StringBuilder string;
            int i = 1;
            string = new StringBuilder("{" + getClass().getSimpleName() + ", cutie recomandata:" + getTipCutie());
            double[] dim = getDimensiuni();
            for(Double val : dim)
            {
                if(val != 0)
                {
                    string.append(", l");
                    string.append(i).append("=").append(val);
                    i++;
                }

            }
            string.append("}");
            return string.toString();
        }
}
