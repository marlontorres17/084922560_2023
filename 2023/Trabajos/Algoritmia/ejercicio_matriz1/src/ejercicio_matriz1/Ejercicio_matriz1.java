/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_matriz1;

import java.util.Scanner;

/**
 *
 * @author srhad
 */
public class Ejercicio_matriz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int sumatoria=0;
        int[][] matriz=new int[2][3];
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                System.out.println("Ingrese el número de la fila "+(i+1)+" y la columna "+(j+1));
                matriz[i][j]=scan.nextInt();
                sumatoria=sumatoria+matriz[i][j];
            }
        }
        System.out.println("La sumatoria de los números almacenados en la matriz es de: " + sumatoria);
    }

}
