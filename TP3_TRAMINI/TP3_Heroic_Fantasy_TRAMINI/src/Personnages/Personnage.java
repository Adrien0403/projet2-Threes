/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

import java.util.ArrayList;
import Armes.Arme;

/**
 *
 * @author adrientramini
 */
public abstract class Personnage {
    String nom;
    int pdv;
    Arme ajouter;
    ArrayList<Arme> tab2 = new ArrayList<Arme>();
    Arme arme_en_main;
    
    
    public void ajouter_arme (Arme armedonnée){
        ajouter=armedonnée;
        int taille3=tab2.size();
        if (taille3 < 5){
        tab2.add(armedonnée);
        }
        
    }
    
    public void équiper_arme (String nomarme){
        for (int i=0 ; i<tab2.size() ; i++){
            if (tab2.get(i).getNom().equals(nomarme)){
                arme_en_main=tab2.get(i);
                System.out.println("L'arme à été trouvé et équipée");
            
        }
        
    
    
    
    }
    }
    
    public Personnage (String n, int pv){
        pdv = pv;
        nom = n;
        arme_en_main=null;
        
        
    }
@Override
public String toString() {
String chaine_a_retourner;
chaine_a_retourner = ("Le magicien "+nom+ " a "+pdv+ "point de vie et manie "+arme_en_main);
System.out.println (chaine_a_retourner);
return(chaine_a_retourner);
}
}
    

