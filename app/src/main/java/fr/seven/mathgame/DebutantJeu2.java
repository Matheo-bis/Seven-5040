package fr.seven.mathgame;

import java.util.Random;

public class DebutantJeu2 extends Equation {
    private static String equationfake1;
    private static String equationfake2;
    private static String equationfake3;
    private static String equationok;

    static String funcequationqcm(int i) {
        if (i == 1) {
            return equationfake1;
        } else if (i == 2) {
            return equationfake2;
        } else if (i == 3) {
            return equationok;
        } else if (i == 4) {
            return equationfake3;
        }
        return "";
    }

    static String bonneequation() {
        return equationok;
    }

    static String equation() {
        Random rand = new Random();
        String operateur;
        int fake1x = rand.nextInt(20) + 1;
        int fake1y = rand.nextInt(20) + 1;
        int fake2x = rand.nextInt(20) + 1;
        int fake2y = rand.nextInt(20) + 1;
        int fake3x = rand.nextInt(20) + 1;
        int fake3y = rand.nextInt(20) + 1;
        switch (rand.nextInt(3)) {
            case 0:
                operateur = "+";
                int Sumy = rand.nextInt(20) + 1;
                int Sumx = rand.nextInt(20) + 1;
                int SumResultat = Sumx + Sumy;
                toutresultat = Sumx + operateur + Sumy + "=" + SumResultat;
                if (fake1x * fake1y == SumResultat) fake1x++;
                equationfake1 = " " + fake1x + operateur + fake1y + " = ";
                if (fake2x * fake2y == SumResultat) fake2x++;
                equationfake2 = " " + fake2x + operateur + fake2y + " = ";
                if (fake3x + fake3y == SumResultat) fake3x++;
                equationfake3 = " " + fake3x + operateur + fake3y + " = ";
                equationok = " " + Sumx + operateur + Sumy + " = ";
                return "" + SumResultat + "";

            case 1:
                operateur = "-";
                int Minx = rand.nextInt(20) + 1;
                int Miny = rand.nextInt(20) + 1;
                if (Miny >= Minx) {
                    int replace = Miny;
                    Miny = Minx;
                    Minx = replace;
                }
                int MinResultat = Minx - Miny;
                toutresultat = Minx + operateur + Miny + "=" + MinResultat;
                if (fake1x - fake1y == MinResultat) fake1x++;
                equationfake1 = " " + fake1x + operateur + fake1y + " = ";
                if (fake2x - fake2y == MinResultat) fake2x++;
                equationfake2 = " " + fake2x + operateur + fake2y + " = ";
                if (fake3x - fake3y == MinResultat) fake3x++;
                equationfake3 = " " + fake3x + operateur + fake3y + " = ";
                equationok = " " + Minx + operateur + Miny + " = ";
                return "" + MinResultat + "";


            case 2:
                operateur = "×";
                int Multx = rand.nextInt(8) + 1;
                int Multy = rand.nextInt(8) + 1;
                int MultResultat = Multx * Multy;
                toutresultat = Multx + operateur + Multy + "=" + MultResultat;
                if (fake1x * fake1y == MultResultat) fake1x++;
                equationfake1 = " " + fake1x + operateur + fake1y + " = ";
                if (fake2x * fake2y == MultResultat) fake2x++;
                equationfake2 = " " + fake2x + operateur + fake2y + " = ";
                if (fake3x * fake3y == MultResultat) fake3x++;
                equationfake3 = " " + fake3x + operateur + fake3y + " = ";
                equationok = " " + Multx + operateur + Multy + " = ";
                return "" + MultResultat + "";
            default:
                return "Attention";
        }
    }

}