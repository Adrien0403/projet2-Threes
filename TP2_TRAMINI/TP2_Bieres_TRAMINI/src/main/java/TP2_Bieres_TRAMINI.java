/*
 * TP2 exercice 1
 * TRAMINI
 * octobre 2023
 */




/**
 *
 * @author adrientramini
 */

public class TP2_Bieres_TRAMINI {
public static void main(String[] args) {
    BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls",7.0 ,"Dubuisson") ;
    uneBiere.ouverte=false;
    System.out.println(uneBiere);
    
    BouteilleBiere autreBiere = new BouteilleBiere("Leffe", 6.6,"Abbaye de Leffe") ;
    autreBiere.ouverte=true;
    autreBiere.decapsuler();
    System.out.println(autreBiere);
    
    BouteilleBiere encoreBiere= new BouteilleBiere ("Cherry Chouffe", 8.0, "Chouffe");
    encoreBiere.ouverte=false;
    System.out.println(encoreBiere);

    BouteilleBiere etBiere= new BouteilleBiere ("8.6", 8.6, "Swinkels");
    etBiere.ouverte=true;
    etBiere.decapsuler();
    System.out.println(etBiere);

    BouteilleBiere etUneBiere= new BouteilleBiere ("heineken blonde", 4, "heineken");
    etUneBiere.ouverte=false;
    System.out.println(etUneBiere);
    }

}