/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg12.pkg8;

import java.util.Scanner;

/**
 *
 * @author Pc-Jhon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int A1, A2;
        int MCD = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero.");
        A1 = sc.nextInt();
        System.out.println("Ingrese otro numero.");
        A2 = sc.nextInt();
        for (int i = 1; i <= A1; i++) {
            if (A1 % i == 0 && A2 % i == 0) {
                MCD = i;
            }
        }
        if (A1 % 2 == 0) {
            System.out.println("El maximo comun divisor de " + A1 + " y " + A2 + " es: " + MCD);
        } else {
            System.out.println("El primer numero no es par.");
        }
    }
    
}
