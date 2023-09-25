/*
 * TP0 calculator
 * TRAMINI
 * septembre 2023
 */
package com.mycompany.calculator;

import java.util.Scanner;
import static javax.management.Query.and;

/**
 *
 * @author adrientramini
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Please enter the operator:\n" +
"1) add\n" +
"2) substract\n" +
"3) multiply\n" +
"4) divide\n" +
"5) modulo");
     int operator;   
Scanner sc = new Scanner(System.in);
System.out.println("");
operator=sc.nextInt();        
    int operande1;

System.out.println("\n Please enter the first number:");
operande1=sc.nextInt();

    int operande2;

System.out.println("\n Please enter the second number:");
operande2 = sc.nextInt();

        int result = 0;

        if (operande1 >= 1 && operande1 <= 5 && operande2 >= 1 && operande2 <=5) { 
            switch (operator) {
                case 1:
                    result = operande1 + operande2;
                    break;
                case 2:
                    result = operande1 - operande2;
                    break;
                case 3:
                    result = operande1 * operande2;
                    break;
                case 4:
                    result = operande1 / operande2;
                    break;
                case 5:
                    result = operande1 % operande2;
                    break;
            }
            System.out.println("Le résultat est : " + result);
        } else {
            System.out.println("Erreur : Les nombres séléctionés doivent être compris entre 1 et 5");
        }
    }
}
