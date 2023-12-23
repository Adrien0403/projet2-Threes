/**
 *
 * @author adrientramini
 */
package le.jeu.thees;
import java.util.Random;


/**
 * La classe Cell représente une cellule du jeu Threes.
 * Chaque cellule a une valeur numérique qui peut être modifiée.
 */
public class Cell {
    private int value;
    
    /**
     * Constructeur par défaut de la cellule. Initialise la valeur à zéro.
     */
    public Cell() {
        this.value = 0;
    }

    /**
     * Obtient la valeur actuelle de la cellule.
     *
     * @return La valeur de la cellule.
     */
    public int getValue() {
        return value;
    }

    /**
     * Modifie la valeur de la cellule.
     *
     * @param value La nouvelle valeur à assigner à la cellule.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Obtient une représentation textuelle de la cellule.
     * Affiche la valeur si elle est différente de zéro, sinon la cellule est considérée comme vide.
     *
     * @return La représentation textuelle de la cellule.
     */
    @Override
    public String toString() {
        // Affiche la valeur si elle est différente de zéro, sinon la cellule est vide
        return (value != 0) ? String.valueOf(value) : " ";
    }
}
