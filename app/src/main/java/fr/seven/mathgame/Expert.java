package fr.seven.mathgame;

import java.util.Random;

public class Expert extends Equation {

    private static int jeuequation = 0;
    private static String equationfake1;
    private static String equationfake2;
    private static String equationok;

    static String resultat() {
        return String.valueOf(toutresultat);
    }

    static int functequation() {
        return jeuequation;
    }

    static String funcequationqcm(int i) {
        if (i == 1) {
            return equationfake1;
        } else if (i == 2) {
            return equationfake2;
        } else if (i == 3) {
            return equationok;
        }
        return "";
    }

    static String bonneequation() {
        return equationok;
    }

    static String equation() {
        Random rand = new Random();
        String operateur;
        String operateur1;
        String operateur2;
        switch (rand.nextInt(6)) {
            case 0:
                jeuequation = 0;
                operateur = "+";
                int Sumx = rand.nextInt(501) + 500;
                int Sumy = rand.nextInt(501) + 500;
                int SumResultat = Sumx + Sumy;
                toutresultat = Sumx + operateur + Sumy + "=" + SumResultat;
                switch (rand.nextInt(3)) {
                    case 0:
                        return Sumx + operateur + Sumy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Sumx + "<b><font color='#33FF99'>_</font></b>" + Sumy + "=" + SumResultat;
                    case 2:
                        jeuequation = 1;
                        int fake1x = rand.nextInt(501) + 500;
                        int fake1y = rand.nextInt(501) + 500;
                        int fake2x = rand.nextInt(501) + 500;
                        int fake2y = rand.nextInt(501) + 500;
                        if (fake1x + fake2x == SumResultat) fake1x = fake1x + 1;
                        equationfake1 = " " + fake1x + operateur + fake2x + " = ";
                        if (fake2x + fake2y == SumResultat) fake2x = fake2x + 1;
                        equationfake2 = " " + fake2x + operateur + fake2y + " = ";
                        equationok = " " + Sumx + operateur + Sumy + " = ";
                        return "" + SumResultat + "";
                }

            case 1:
                jeuequation=0;
                operateur = "-";
                int Minx = rand.nextInt(501) + 500;
                int Miny = rand.nextInt(501) + 500;
                if (Miny >= Minx) {
                    int replace = Miny;
                    Miny = Minx;
                    Minx = replace;
                }
                int MinResultat = Minx - Miny;
                toutresultat = Minx + operateur + Miny + "=" + MinResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Minx + operateur + Miny + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Minx + "<b><font color='#33FF99'>_</font></b>" + Miny + "=" + MinResultat;
                    case 2:
                        jeuequation = 1;
                        int fake1x = rand.nextInt(501) + 500;
                        int fake1y = rand.nextInt(501) + 500;
                        int fake2x = rand.nextInt(501) + 500;
                        int fake2y = rand.nextInt(501) + 500;
                        if (fake1x - fake2x == MinResultat) fake1x = fake1x + 1;
                        equationfake1 = " " + fake1x + operateur + fake2x + " = ";
                        if (fake2x - fake2y == MinResultat) fake2x = fake2x + 1;
                        equationfake2 = " " + fake2x + operateur + fake2y + " = ";
                        equationok = " " + Minx + operateur + Miny + " = ";
                        return "" + MinResultat + "";
                }
            case 2:
                jeuequation=0;
                operateur = "×";
                int Multx = rand.nextInt(31) + 10;
                int Multy = rand.nextInt(31) + 10;
                int MultResultat = Multx * Multy;
                toutresultat = Multx + operateur + Multy + "=" + MultResultat;
                switch (rand.nextInt(3)) {
                    case 0:
                        return Multx + operateur + Multy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Multx + "<b><font color='#33FF99'>_</font></b>" + Multy + "=" + MultResultat;
                    case 2:
                        jeuequation = 1;
                        int fake1x = rand.nextInt(30)+10;
                        int fake1y = rand.nextInt(15)+5;
                        int fake2x = rand.nextInt(31)+10;
                        int fake2y = rand.nextInt(15)+5;
                        if (fake1x * fake2x == MultResultat) fake1x = fake1x + 1;
                        equationfake1 = " "+fake1x + operateur + fake2x + " = ";
                        if (fake2x * fake2y == MultResultat) fake2x = fake2x + 1;
                        equationfake2 = " "+fake2x + operateur + fake2y + " = ";
                        equationok = " "+Multx + operateur + Multy + " = ";
                        return "" + MultResultat + "";
                }
            case 3:
                jeuequation=0;
                operateur = "÷";
                int Divy = rand.nextInt(501) + 50;
                int DivResultat = rand.nextInt(20)+1;
                int Divx = Divy * DivResultat;
                toutresultat = Divx + operateur + Divy + "=" + DivResultat;
                switch (rand.nextInt(3)) {
                    case 0:
                        return Divx + operateur + Divy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(DivResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Divx + "<b><font color='#33FF99'>_</font></b>" + Divy + "=" + DivResultat;
                    case 2:
                        jeuequation = 1;
                        int fake1x = rand.nextInt(101)+1;
                        int fake1y = rand.nextInt(21)+1;
                        int fake2x = rand.nextInt(101)+1;
                        int fake2y = rand.nextInt(21)+1;
                        if (fake1x * fake2x == Divx) fake1x = fake1x + 1;
                        equationfake1 = " "+fake1x + operateur + fake2x + " = ";
                        if (fake2x * fake2y == Divx) fake2x = fake2x + 1;
                        equationfake2 = " "+fake2x + operateur + fake2y + " = ";
                        equationok = " "+Divx + operateur + Divy + " = ";
                        return "" + DivResultat + "";
                }
            case 4:
                jeuequation=0;
                operateur1 = "+";
                operateur2 = "-";
                int Summinx = rand.nextInt(501) + 500;
                int Summiny = rand.nextInt(501) + 500;
                int Summinz = rand.nextInt(901) + 100;
                int Resultat;
                switch (rand.nextInt(2)){
                    case 0:
                        Resultat = Summinx + Summiny - Summinz;
                        toutresultat = Summinx+operateur1+Summiny +operateur2+Summinz+"="+ Resultat;
                        break;
                    default:
                        Resultat = Summinx - Summiny + Summinz;
                        String operate = operateur1;
                        operateur1=operateur2;
                        operateur2 =operate;
                        toutresultat = Summinx+operateur1+Summiny +operateur2+Summinz+"="+ Resultat;
                        break;
                }
                switch (rand.nextInt(2)) {
                    case 0:
                        return Summinx + operateur1 + Summiny + operateur2 + Summinz + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(Resultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Summinx + "<b><font color='#33FF99'>_</font></b>" + Summiny + "<b><font color='#33FF99'>_</font></b>" + Summinz + "=" + Resultat;
                }

            case 5:
                jeuequation=0;
                operateur1 = "+";
                operateur2 = "*";
                int Summultx = rand.nextInt(501) + 500;
                int Summulty = rand.nextInt(501) + 500;
                int Summultz = rand.nextInt(901) + 100;
                int Resultat2;
                switch (rand.nextInt(2)){
                    case 0:
                        Resultat2 = Summultx + Summulty * Summultz;
                        toutresultat = Summultx+operateur1+Summulty +operateur2+Summultz+"="+ Resultat2;
                        break;
                    default:
                        Resultat2 = Summultx * Summulty + Summultz;
                        String operate = operateur1;
                        operateur1=operateur2;
                        operateur2 =operate;
                        toutresultat = Summultx+operateur2+Summulty +operateur1+Summultz+"="+ Resultat2;
                        break;
                }
                switch (rand.nextInt(2)) {
                    case 0:
                        return Summultx + operateur1 + Summulty + operateur2 + Summultz + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(Resultat2).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Summultx + "<b><font color='#33FF99'>_</font></b>" + Summulty + "<b><font color='#33FF99'>_</font></b>" + Summultz + "=" + Resultat2;
                }
            default:
                return "Attention";
        }
    }
}
