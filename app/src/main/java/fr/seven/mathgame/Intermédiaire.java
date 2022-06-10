package fr.seven.mathgame;

import java.util.Random;

public class Intermédiaire extends Equation{



    static String resultat() {
        return String.valueOf(toutresultat);
    }


    static String equation() {
        Random rand = new Random();
        String operateur;
        String operateur1;
        String operateur2;
        switch (rand.nextInt(5)) {
            case 0:
                operateur = "+";
                int Sumx = rand.nextInt(51)+50;
                int Sumy = rand.nextInt(51)+50;
                int SumResultat = Sumx + Sumy;
                toutresultat = Sumx+operateur+Sumy +"="+ SumResultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return Sumx + operateur + Sumy + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(SumResultat).length()]).replace('\u0000', '_')+"</font></b>";
                    case 1:
                        return Sumx+"<b><font color='#33FF99'>_</font></b>"+Sumy+ "=" +SumResultat;
                }
            case 1:
                operateur = "-";
                int Minx = rand.nextInt(151)+50;
                int Miny = rand.nextInt(151)+50;
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
                int Multx = rand.nextInt(11)+10;
                int Multy = rand.nextInt(6)+5;
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
                int Divy=rand.nextInt(14)+1;
                int DivResultat=rand.nextInt(5);
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
                int x = rand.nextInt(51)+50;
                int y = rand.nextInt(51)+50;
                int z = rand.nextInt(91)+10;
                int Resultat = x + y - z;
                toutresultat = x+operateur1+y +operateur2+z+"="+ Resultat;
                switch (rand.nextInt(2)) {
                    case 0:
                        return x + operateur1 + y + operateur2 + z + "=<b><font color='#33FF99'>" + new String(new char[String.valueOf(Resultat).length()]).replace('\u0000', '_')+"</font></b>";
                    case 1:
                        return x + "<b><font color='#33FF99'>_</font></b>" + y + "<b><font color='#33FF99'>_</font></b>" + z + "=" + Resultat;
                }
            default:
                return "Attention";
        }
    }
}
