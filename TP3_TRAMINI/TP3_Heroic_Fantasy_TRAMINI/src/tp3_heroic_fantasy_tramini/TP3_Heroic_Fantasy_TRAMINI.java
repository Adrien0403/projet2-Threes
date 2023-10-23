/*
 * TP3
 * TRAMINI
 * octobre 2023
 */
package tp3_heroic_fantasy_tramini;

import Armes.épée;
import Armes.baton;
import Armes.Arme;
import Personnages.Magicien;
import Personnages.Guerrier;
import Personnages.Personnage;
import java.util.ArrayList;

/**
 *
 * @author adrientramini
 */
public class TP3_Heroic_Fantasy_TRAMINI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        épée épée1 = new épée("Excalibur", 7, 5);
        épée épée2 = new épée("Durandal", 4, 7);
        
        baton baton1 = new baton("Chêne", 4, 5);
        baton baton2 = new baton("Charme", 5, 6);
        
        System.out.println(baton1);
        System.out.println(baton2);
        System.out.println(épée1);
        System.out.println(épée2);
        
        ArrayList<Arme> n_arme = new ArrayList<Arme>();
        n_arme.add(épée1);
        n_arme.add(épée2);
        n_arme.add(baton1);
        n_arme.add(baton2);
        
        int taille = n_arme.size();
        int longueur=taille;
        for (int i=0 ; i<longueur; i++){
            System.out.println(n_arme.get(i));
          
    }
        Magicien magi1 = new Magicien ("Gandalf", 65, true);
        Magicien magi2 = new Magicien ("Garcimor", 44, false);
        Guerrier g1 = new Guerrier ("Conan", 78, false);
        Guerrier g2 = new Guerrier ("Lannister", 45, true);
        
        System.out.println(magi1);
        System.out.println(magi2);
        System.out.println(g1);
        System.out.println(g2);
        
         ArrayList<Personnage> tab_p = new ArrayList<Personnage>();
        tab_p.add(magi1);
        tab_p.add(magi2);
        tab_p.add(g1);
        tab_p.add(g2);
        
        int taille2 =tab_p.size();
        
        int longueur2=taille2-1;
        for (int i=0 ; i<longueur2; i++){
            System.out.println(tab_p.get(i));
        
        Guerrier g3 = new Guerrier ("Audric quinic", 1,true);
        Magicien magi3 = new Magicien ("Arthur lafole", 99, false);
        
        baton baton10 = new baton ("brindille1", 4 , 9);
        baton baton11 = new baton ("brindille2", 3 , 4);
        baton baton12 = new baton ("brindille3", 6 , 1);
        
        épée épée10 = new épée ("épéé diam", 99, 99);
        épée épée11 = new épée ("épéé fer", 5, 6);
        épée épée12 = new épée ("épéé bronze", 1, 6);
        
        g3.ajouter_arme(épée10);
        g3.ajouter_arme(épée11);
        g3.ajouter_arme(baton10);
        
        magi3.ajouter_arme(baton11);
        magi3.ajouter_arme(baton12);
        magi3.ajouter_arme(épée12);
        
        g3.équiper_arme("épéé diam");
        magi3.équiper_arme("épéé bronze");
      
        System.out.println(g3);
        System.out.println(magi3);
        
}
    
}
    }
