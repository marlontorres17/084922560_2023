/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg11.pkg6;

import java.util.Scanner;

/**
 *
 * @author Ambiente 209-1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int censo = 0;
        int[][] people = new int[1000][4];
        while (censo != 1000) {
            censo++;
            people[censo][0] = censo;
            System.out.println("Numero de censo: " + censo);
            System.out.println("Sexo:");
            System.out.println("1. Masculino.");
            System.out.println("2. Femenino.");
            people[censo][1] = scan.nextInt();
            if (people[censo][1] != 1 & people[censo][1] != 2) {
                System.out.println("Opcion no valida.");
                System.out.println("Censo anulado.");
            } else {
                System.out.println("Ingrese la edad.");
                people[censo][2] = scan.nextInt();
                System.out.println("Estado civil:");
                System.out.println("1. Soltero.");
                System.out.println("2. Casado.");
                System.out.println("3. Viudo.");
                System.out.println("4. Divorciado.");
                people[censo][3] = scan.nextInt();
                if (people[censo][3] > 4 || people[censo][3] < 1) {
                    System.out.println("Opcion no valida.");
                    System.out.println("Censo anulado.");
                }
            }
        }
        System.out.println("El numero de censo de las jovenes solteras entre 16 y 21 es:");
        for (int i = 0; i <= 1000; i++) {
            if (people[i][2] > 15 & people[i][2] < 22 & people[i][1] == 2 & people[i][3] == 1) {
                System.out.println(people[i][0]);
            }
        }
    }
}
