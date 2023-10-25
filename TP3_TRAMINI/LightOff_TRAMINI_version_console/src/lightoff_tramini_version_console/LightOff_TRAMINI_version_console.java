/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lightoff_tramini_version_console;

/**
 *
 * @author adrientramini
 */
public class LightOff_TRAMINI_version_console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         CelluleLumineuse cellulelumineuse1 = new CelluleLumineuse();
        CelluleLumineuse cellulelumineuse2 = new CelluleLumineuse();

        System.out.println("État initial de la cellule 1 : " + cellulelumineuse1.estAllumee());
        System.out.println("État initial de la cellule 2 : " + cellulelumineuse2.estAllumee());

        cellulelumineuse1.allumer();
        cellulelumineuse2.eteindre();

        System.out.println("État de la cellule 1 après l'allumage : " + cellulelumineuse1.estAllumee());
        System.out.println("État de la cellule 2 après l'extinction : " + cellulelumineuse2.estAllumee());

    }
    
}
