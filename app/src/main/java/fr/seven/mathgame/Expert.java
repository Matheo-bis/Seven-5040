package fr.seven.mathgame;

import java.util.Random;

public class Expert extends Equation{


    static String resultat() {
        return String.valueOf(toutresultat);
    }


    static String equation() {
        Random rand = new Random();
        String operateur;
        String operateur1;
        String operateur2;
        switch (rand.nextInt(6)) {
            case 0:
                operateur = "+";
                int Sumx = rand.nextInt(501)+500;
                int Sumy = rand.nextInt(501)+500;
                int SumResultat = Sumx + Sumy;
                toutresultat = Sumx+operateur+Sumy +"="+ SumResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Sumx + operateur + Sumy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Sumx + "<b><font color='#33FF99'>_</font></b>" + Sumy + "=" + SumResultat;
                }

            case 1:
                operateur = "-";
                int Minx = rand.nextInt(501)+500;
                int Miny = rand.nextInt(501)+500;
                if (Miny >= Minx) {
                    int replace = Miny;
                    Miny = Minx;
                    Minx = replace;
                }
                int MinResultat = Minx - Miny;
                toutresultat = Minx+operateur+Miny+"="+MinResultat;
                switch(rand.nextInt(2)) {
                    case 0:
                        return Minx + operateur + Miny + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(MinResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Minx + "<b><font color='#33FF99'>_</font></b>" + Miny + "=" + MinResultat;
                }
            case 2:
                operateur = "×";
                int Multx = rand.nextInt(31)+10;
                int Multy = rand.nextInt(31)+10;
                int MultResultat = Multx * Multy;
                toutresultat = Multx+operateur+Multy+"="+MultResultat;
                switch(rand.nextInt(2)) {
                    case 0:
                        return Multx + operateur + Multy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(MultResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Multx + "<b><font color='#33FF99'>_</font></b>" + Multy + "=" + MultResultat;
                }
            case 3:
                operateur ="÷";
                int Divy=rand.nextInt(501)+50;
                int DivResultat=rand.nextInt(20);
                int Divx=Divy*DivResultat;
                toutresultat = Divx+operateur+Divy+"="+DivResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Divx + operateur + Divy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(DivResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Divx + "<b><font color='#33FF99'>_</font></b>" + Divy + "=" + DivResultat;
                }
            case 4:
                operateur1 = "+";
                operateur2= "-";
                int Summinx = rand.nextInt(501)+500;
                int Summiny = rand.nextInt(501)+500;
                int Summinz = rand.nextInt(901)+100;
                int SumminResultat = Summinx + Summiny - Summinz;
                toutresultat = Summinx+operateur1+Summiny +operateur2+Summinz+"="+ SumminResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Summinx + operateur1 + Summiny + operateur2 + Summinz + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(SumminResultat).length()]).replace('\u0000', '_')+ "</font></b>";
                    case 1:
                        return Summinx + "<b><font color='#33FF99'>_</font></b>" + Summiny + "<b><font color='#33FF99'>_</font></b>" + Summinz + "=" +SumminResultat;
                }

            case 5:
                operateur1 = "+";
                operateur2= "*";
                int Summultx = rand.nextInt(501)+500;
                int Summulty = rand.nextInt(501)+500;
                int Summultz = rand.nextInt(901)+100;
                int SummultResultat = Summultx + Summulty - Summultz;
                toutresultat = Summultx+operateur1+Summulty +operateur2+Summultz+"="+ SummultResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Summultx + operateur1 + Summulty + operateur2 + Summultz + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(SummultResultat).length()]).replace('\u0000', '_') + "</font></b>";
                    case 1:
                        return Summultx + "<b><font color='#33FF99'>_</font></b>" + Summulty + "<b><font color='#33FF99'>_</font></b>" + Summultz + "=" + SummultResultat;
                }
            default:
                return "Attention";
        }
    }
}
