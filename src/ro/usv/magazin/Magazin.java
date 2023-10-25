package ro.usv.magazin;

import ro.usv.cutii.Cilindru;
import ro.usv.cutii.Cub;
import ro.usv.cutii.ICutie;
import ro.usv.cutii.Paralelipiped;
import ro.usv.jucarii.Avion;
import ro.usv.jucarii.Jucarie;
import ro.usv.jucarii.Minge;
import ro.usv.jucarii.Racheta;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;

public class Magazin {
    private ArrayList<Pachet> listaVanzari;
    public Magazin() {
    }

    public ArrayList<Pachet> getListaVanzari()
    {
        return listaVanzari = new ArrayList<>();
    }

    public void citesteVanzari(String numeFisier) throws FileNotFoundException {
        double DimMinge = 10;
        double[] DimAvion = new double[] {10,20,30};
        double[] DimRacheta = new double[] {10,20};
        String line;
        String[] Result;
        Scanner scanner = new Scanner(new File(numeFisier));

        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            line = line.toLowerCase();
            Result = line.split("\\s+");
            switch (Result[0])
            {
                case "minge" -> listaVanzari.add( new Pachet(new Minge(DimMinge), Result[1].equals("da"), Result[2].equals("da")) );
                case "racheta" -> listaVanzari.add( new Pachet(new Racheta(DimRacheta[0], DimRacheta[1]), Result[1].equals("da"), Result[2].equals("da")) );

                case "avion" -> listaVanzari.add( new Pachet(new Avion(DimAvion[0], DimAvion[1], DimAvion[2]), Result[1].equals("da"), Result[2].equals("da")) );
                default -> throw new IllegalStateException("Unexpected value: " + Result[0]);
            }
        }
        scanner.close();
    }

    public int cautaPachet(Pachet x)
    {
        return  listaVanzari.indexOf(x);
    }

    public void afisPacheteDupaPret(boolean descrescator)
    {
        ArrayList<Pachet> CopielistaVanzari = new ArrayList<>(listaVanzari);
        if(descrescator)
        {
            System.out.println("Afisare pachete in functie de pretul descrescator");
            CopielistaVanzari.sort(Comparator.comparing(Pachet::pretPachet).reversed());
            for (Pachet pachet : CopielistaVanzari)
            {
                System.out.println(listaVanzari.indexOf(pachet) + "." + pachet);
                System.out.println("Pret=" + pachet.pretPachet());
            }
        }
        else
        {
            System.out.println("Afisare pachete in functie de pretul crescator");
            CopielistaVanzari.sort(Comparator.comparing(Pachet::pretPachet));
            for (Pachet pachet : CopielistaVanzari)
            {
                System.out.println(listaVanzari.indexOf(pachet) + "." + pachet);
                System.out.println("Pret=" + pachet.pretPachet());
            }
        }
    }

    public void afisVanzari()
    {
        double PretTotal = 0;
        System.out.println("Vanzari efectuate");
        for (Pachet pachet : listaVanzari)
        {
            System.out.println(listaVanzari.indexOf(pachet) + "." + pachet);
            PretTotal += pachet.pretPachet();
            System.out.println("Pret=" + pachet.pretPachet());
        }
        System.out.println("Suma totala incasata=" + PretTotal);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String NumeFisier = "date.txt";

//        System.out.println("===== Demo Cutii (2p) =====");
//        ICutie cutie1 = new Paralelipiped(10,20,30);
//        ICutie cutie2 = new Cub(40);
//        ICutie cutie3 = new Cilindru(50,60);
//        ICutie[] cutii = new ICutie[] {cutie1, cutie2, cutie3};
//        System.out.println(Arrays.toString(cutii));
//
//        System.out.println();
//
//        System.out.println("===== Demo Jucarii (2p) =====");
//        Jucarie jucarie1 = new Avion(15,25,35);
//        Jucarie jucarie2 = new Minge(45);
//        Jucarie jucarie3 = new Racheta(55,65);
//        Jucarie[] jucarii = new Jucarie[] {jucarie1, jucarie2, jucarie3};
//        System.out.println(Arrays.toString(jucarii));
//
//        System.out.println();
//
//        System.out.println("===== Demo Fabrica de cutii (1p) =====");
//        ICutie cutiejucarie1 = FabricaCutii.getCutie(jucarie1);
//        System.out.println("Pentru jucaria:" + jucarie1 + " " + cutiejucarie1);
//        ICutie cutiejucarie2 = FabricaCutii.getCutie(jucarie2);
//        System.out.println("Pentru jucaria:" + jucarie2 + " " + cutiejucarie2);
//        ICutie cutiejucarie3 = FabricaCutii.getCutie(jucarie3);
//        System.out.println("Pentru jucaria:" + jucarie3 + " " + cutiejucarie3);

//        System.out.println();
//
//        System.out.println("===== Demo Panglica (1p) =====");
//        System.out.println("Pentru cutia: " + cutie1 + " necesar lung_panglica=" + cutie1.getLungimePanglica() + " dupa cumparare: {RolaPanglica, disponibil=" +
//                RolaPanglica.getRola().cumpara(cutie1.getLungimePanglica()) + "}");
//        System.out.println("Pentru cutia: " + cutie2 + " necesar lung_panglica=" + cutie2.getLungimePanglica() + " dupa cumparare: {RolaPanglica, disponibil=" +
//                RolaPanglica.getRola().cumpara(cutie2.getLungimePanglica()) + "}");
//        System.out.println("Pentru cutia: " + cutie3 + " necesar lung_panglica=" + cutie3.getLungimePanglica() + " dupa cumparare: {RolaPanglica, disponibil=" +
//                RolaPanglica.getRola().cumpara(cutie3.getLungimePanglica()) + "}");
//
//        System.out.println();
//
        System.out.println("\n===== Demo Magazin (2p) =====");
        Magazin m = new Magazin();
        List<Pachet> vanzari = m.getListaVanzari();
//        vanzari.add( new Pachet(new Minge(10), true, true) );
//        vanzari.add( new Pachet(new Minge(10), true, false) );
//        vanzari.add( new Pachet(new Minge(10), true, true) );
//        vanzari.add( new Pachet(new Minge(10), false, false) );
//        vanzari.add( new Pachet(new Racheta(10,20), false, false) );
//        vanzari.add( new Pachet(new Avion(10,20,30), false, false) );
//        vanzari.add( new Pachet(new Avion(10,20,30), true, false) );
//        m.afisVanzari();


//        System.out.println();
//        m.afisPacheteDupaPret(true);
//        System.out.println();
//        m.afisPacheteDupaPret(false);
//
//        System.out.println();

//        int raspuns = m.cautaPachet(new Pachet(new Avion(10,20, 30), true, false));
//
//        if(raspuns != -1)
//            System.out.println("Pachetul a fost gasit pe pozitia " + raspuns);
//        else {
//            System.out.println("Pachetul nu a fost gasit");
//        }
        m.citesteVanzari(NumeFisier);
        m.afisVanzari();
        System.out.println("In rola au mai ramas "+
                RolaPanglica.getRola().getDisponibil()+" cm");
    }
}