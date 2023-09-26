/*
 * TP0 exercice 2
 * TRAMINI
 * septembre 2023
 */

package com.mycompany.tp1;

import java.util.Scanner;

/**
 *
 * @author adrientramini
 */
public class TP1 {
    public static void main(String[] args) {
int nb1;
int nb2;
    
Scanner sc = new Scanner(System.in);
System.out.println("\n Entrer le premier nombre :");
nb1=sc.nextInt();

System.out.println("\n Entrer le dexieme nombre :");
nb2=sc.nextInt();

int somme;
int soustraction;
int produit;

somme = nb1 + nb2;
soustraction = nb1 - nb2;
produit= nb1 * nb2;

System.out.println("La somme des nombres est : "+ somme + "Leur différence est de : "+soustraction+ "et le produit est : "+produit);
}
    }

