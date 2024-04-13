/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg12.pkg7;

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
        int A1, A2, MCM = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un numero.");
        A1 = sc.nextInt();
        System.out.print("Ingrese otro numero.");
        A2 = sc.nextInt();
        int min = Math.min(A1, A2);

        for (int i = 1; i < min; i++) {
            if (A1 % i == 0 && A2 % i == 0) {
                int mcd = i;

                MCM = (A1 * A2) / mcd;
            }
        }
        System.out.println("El maximo comun multiplo de  " + A1 + "  y  " + A2 + " es: " + MCM);
    }
    
}
