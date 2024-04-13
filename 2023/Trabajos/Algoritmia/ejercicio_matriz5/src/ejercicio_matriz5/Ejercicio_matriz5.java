/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_matriz5;

import java.util.Scanner;

/**
 *
 * @author srhad
 */
public class Ejercicio_matriz5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[5][5];
        int[] diagonal = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Ingrese el valor para la fila " + (i + 1) + ",columna " + (j + 1));
                matriz[i][j] = scan.nextInt();
                if (i == j) {
                    diagonal[i] = matriz[i][j];
                }
            }
        }
        System.out.println("Matriz:");
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            System.out.print("|");
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "|");
            }
        }
        System.out.println("");
        System.out.println("Diagonal principal:");
        for (int i = 0; i < 5; i++) {
            System.out.println("");
            System.out.print("|");
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    System.out.print(diagonal[j] + "|");
                } else {
                    System.out.print(" |");
                }
            }
        }
    }

}
