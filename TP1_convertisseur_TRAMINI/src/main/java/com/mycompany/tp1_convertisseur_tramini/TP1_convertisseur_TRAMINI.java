/*
 * TP0 exercice 1
 * TRAMINI
 * septembre 2023
 */

package com.mycompany.tp1_convertisseur_tramini;

import java.util.Scanner;

/**
 *
 * @author adrientramini
 */
public class TP1_convertisseur_TRAMINI {
     public static void main(String[] args) {
         double temp;
Scanner sc = new Scanner(System.in);
System.out.println("\n Bonjour, saisissez une valeur :");
temp=sc.nextDouble();

        System.out.println("Saisissez la conversion que vous souhaiter effectuer : "+
"1) KelvinVersCelcius\n" +
"2) FarenheitVersCelcius\n" +
"3) CelciusVersFarenheit\n" +
"4) KelvinVersFarenheit\n" +
"5) FarenheitVersKelvin");
     int convert;   

System.out.println("");
convert=sc.nextInt();        

        double result = 0;

        
            switch (convert) {
                case 1:
                    result = temp - 273.15;
                    break;
                case 2:
                    result = (temp - 32)/1.8;
                    break;
                case 3:
                    result = temp*1.8+32;
                    break;
                case 4:
                    result = (temp - 273.15)*1.8+32;
                    break;
                case 5:
                    result = (temp - 32)*1.8+ 273.15;
                    break;
            }
            System.out.println("Le résultat est : " + result);
        } 
    }

    
