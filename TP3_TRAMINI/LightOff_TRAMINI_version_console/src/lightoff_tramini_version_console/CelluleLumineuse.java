/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lightoff_tramini_version_console;

/**
 *
 * @author adrientramini
 */
public class CelluleLumineuse {
    private boolean allumee;

    /**
     * par defaut la cellule est eteinte
     */
    public CelluleLumineuse() {
        this.allumee = false;
    }

    /**
     * verifie si la cellule est allumer
     * @return " la cellule est allumee" si elle est allumee et " la cellule est eteinte" si elle est eteinte
     */
    public String estAllumee() {
        String etat_cellule;
        if (allumee== true){
           etat_cellule = (" la cellule est allumee");
           return etat_cellule;
        }
        else {
            etat_cellule = (" la cellule est eteinte");
            return etat_cellule;
        }
          
        
    }

    /**
     * allume la cellule 
     */
    public void allumer() {
        allumee = true;
    }

    /**
     * eteint la cellule 
     */
    public void eteindre() {
        allumee = false;
    }
    
}
