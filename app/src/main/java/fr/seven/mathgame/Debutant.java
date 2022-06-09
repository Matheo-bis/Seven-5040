package fr.seven.mathgame;

import android.view.View;

import java.util.Random;

public class Debutant extends Equation {
    private static String toutresultat;

    static String equation() {
        Random rand = new Random();
        switch (rand.nextInt(2)) {
            case 0:
                return jeuatrouchiffre();
            case 1:
                return jeuequation();
            default:
                return "Attention";
        }
    }

    private static String jeuequation(){
        Random rand = new Random();

        return "jeu equation a faire";
    }

    static String resultat() {
        return String.valueOf(toutresultat);
    }


   private static String jeuatrouchiffre() {
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
                        return Sumx + operateur + Sumy + "=" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_');
                    case 1:
                        return Sumx +"_"+Sumy+ "=" +SumResultat;
                    default:
                        return "Attention";
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
                        return Minx + operateur + Miny + "=" + new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_');
                    case 1:
                        return Minx+"_"+Miny+ "=" +MinResultat;
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
                        return Multx + operateur + Multy + "=" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_');
                    case 1:
                        return Multx + "_" + Multy + "="+ MultResultat;
                    default:
                        return "Attention";
                }
            default:
                return "Attention";
        }
    }
}