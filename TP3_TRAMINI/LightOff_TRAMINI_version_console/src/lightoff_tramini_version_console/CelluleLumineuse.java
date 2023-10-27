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
    private boolean etat;

    /**
     * par defaut la cellule est eteinte
     */
    public CelluleLumineuse() {
        this.etat = false;
    }
    
    /**
     * permet d'echanger l'etat d'une cellule 
     * @return true si la cellule est allumé et false si elle est eteinte
     */
    public boolean estEteint() {
    if (etat==true){
        etat = false;// Renvoie vrai si l'état est faux (éteint), sinon faux (allumé)
}
    else {
        etat = true;
    }
        return etat;
    }
    
    /**
     * verifie si la cellule est allumer
     * @return true si elle est allumee et false si elle est eteinte
     */
    public boolean getEtat() {
    return etat;
}

    /**
     * allume la cellule 
     */
    public void activerCellule() {
        etat = true;
    }

    /**
     * eteint la cellule 
     */
    public void eteindreCellule() {
        etat = false;
    }
    @Override
public String toString() {
String etat_cellule;
if (etat == true){
etat_cellule = ("O");
return etat_cellule;
}
else {
    etat_cellule = ("X");

   return etat_cellule; 
}
}}
