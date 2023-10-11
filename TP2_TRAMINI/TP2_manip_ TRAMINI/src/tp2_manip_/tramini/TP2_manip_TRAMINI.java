/*
 * TP2 exercice 3
 * TRAMINI
 * octobre 2023
 */
package tp2_manip_.tramini;

/**
 *
 * @author adrientramini
 */
public class TP2_manip_TRAMINI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Tartiflette assiette1 = new Tartiflette(500);
Tartiflette assiette2 = new Tartiflette(600);
Tartiflette assiette3 = assiette2;

System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);
System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories);

assiette2 = assiette1;
assiette1.nbCalories = 800;

System.out.println("nb de calories de Assiette 2 : " + assiette2.nbCalories);
System.out.println("nb de calories de Assiette 3 : " + assiette3.nbCalories);

Tartiflette temp = assiette1;
assiette1 = assiette2;
assiette2 = temp;


Moussaka[] assiettes = new Moussaka[10];

for (int i = 0; i < assiettes.length; i++) {
    assiettes[i] = new Moussaka(400); 
    System.out.println("nb de calories de Assiette 3 : " + assiettes[i].nbCalories);

}
    }
   
    
}
