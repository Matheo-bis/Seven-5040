package fr.seven.mathgame;

import java.util.Random;

public class Debutant extends Equation {
    private static String toutresultat;

    static String equation() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                return jeuatrouchiffre();
            case 1:
                return jeuatrouchiffre();
                //jeuatrouoperateur();
            case 2:
                return jeuatrouchiffre();
            default:
                return "Attention";
        }
    }

    private static String jeuatrouoperateur(){
        Random rand = new Random();
        switch (rand.nextInt(2)){
            case 0:
                return "";
            default:
                return "Atttention";
        }
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
                int Sumx = rand.nextInt(21);
                int Sumy = rand.nextInt(21);
                String StringSumx = String.valueOf(Sumx);
                String StringSumy = String.valueOf(Sumy);
                int SumResultat = Sumx + Sumy;
                toutresultat = StringSumx+operateur+StringSumy +"="+ SumResultat;
                return StringSumx + operateur + StringSumy + "=" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_');

            case 1:
                operateur = "-";
                int Minx = rand.nextInt(21);
                int Miny = rand.nextInt(21);
                if (Miny >= Minx) {
                    int replace = Miny;
                    Miny = Minx;
                    Minx = replace;
                }
                String StringMinx = String.valueOf(Minx);
                String StringMiny = String.valueOf(Miny);
                int MinResultat = Minx - Miny;
                toutresultat = StringMinx+operateur+StringMiny+"="+MinResultat;
                return StringMinx + operateur + StringMiny + "=" + new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_');

            case 2:
                operateur = "x";
                int Multx = rand.nextInt(6);
                int Multy = rand.nextInt(6);
                String StringMultx = String.valueOf(Multx);
                String StringMulty = String.valueOf(Multy);
                int MultResultat = Multx * Multy;
                toutresultat = StringMultx+operateur+StringMulty+"="+MultResultat;
                return StringMultx + operateur + StringMulty + "=" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_');

            default:
                return "Attention";
        }
    }
}