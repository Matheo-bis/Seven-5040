package fr.seven.mathgame;

import android.view.View;

import java.util.Random;

public class Debutant extends Equation {
    private static String toutresultat;


    static String resultat() {
        return String.valueOf(toutresultat);
    }

    static String equation() {
        Random rand = new Random();
        String operateur;
        switch (rand.nextInt(3)) {
            case 0:
                operateur = "+";
                int Sumy = rand.nextInt(20) + 1;
                int Sumx = rand.nextInt(20) + 1;
                int SumResultat = Sumx + Sumy;
                toutresultat = Sumx + operateur + Sumy + "=" + SumResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Sumx + operateur + Sumy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_')+"</font></b>";
                    case 1:
                        return Sumx +"<b><font color='#33FF99'>_</font></b>"+Sumy+ "=" +SumResultat;
                    case 2:
                        int fake1x = rand.nextInt(20)+1;
                        int fake1y = rand.nextInt(20)+1;
                        int fake2x = rand.nextInt(20)+1;
                        int fake2y = rand.nextInt(20)+1;
                        int equationfake1= fake1x + fake2x;
                        if (equationfake1==SumResultat)fake1x=fake1x+1;
                        int equationfake2 = fake2x+fake2y;
                        if (equationfake2==SumResultat)fake2x=fake2x+1;
                        return SumResultat+"";

                }
            case 1:
                operateur = "-";
                int Minx = rand.nextInt(20)+1;
                int Miny = rand.nextInt(20)+1;
                if (Miny >= Minx) {
                    int replace = Miny;
                    Miny = Minx;
                    Minx = replace;
                }
                int MinResultat = Minx - Miny;
                toutresultat = Minx+operateur+Miny+"="+MinResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Minx + operateur + Miny + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_')+"</font></b>";
                    case 1:
                        return Minx+"<b><font color='#33FF99'>_</font></b>"+Miny+ "=" +MinResultat;
                    default:
                        return "Attention";
                }
            case 2:
                operateur = "×";
                int Multx = rand.nextInt(5)+1;
                int Multy = rand.nextInt(5)+1;
                int MultResultat = Multx * Multy;
                toutresultat = Multx+operateur+Multy+"="+MultResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Multx + operateur + Multy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_')+"</font></b>";
                    case 1:
                        return Multx + "<b><font color='#33FF99'>_</font></b>" + Multy + "="+ MultResultat;
                    default:
                        return "Attention";
                }
            default:
                return "Attention";
        }
    }

}