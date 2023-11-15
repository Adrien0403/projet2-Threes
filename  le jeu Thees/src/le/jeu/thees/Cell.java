/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package le.jeu.thees;
import java.util.Random;
/**
 *
 * @author adrientramini
 */
public class Cell {
    private int value;

    public Cell() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        // Affiche la valeur si elle est différente de zéro, sinon la cellule est vide
        return (value != 0) ? String.valueOf(value) : " ";
    }
}
