/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_matriz3;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit;
/**
 *
 * @author srhad
 */
public class Ejercicio_matriz3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
         int[][] matriz=new int[3][3];
         int[] fila=new int[3];
         int[] columna=new int[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println("Ingrese el valor de la fila "+(i+1)+",columna "+(j+1));
                matriz[i][j]=scan.nextInt();
                columna[j]=matriz[i][j]+columna[j];
                fila[i]=matriz[i][j]+fila[i];
            }
        }
        for(int i=0;i<3;i++){
        System.out.println("La suma de la columna "+(i+1)+" es: "+columna[i]);
        System.out.println("La suma de la fila "+(i+1)+" es: "+fila[i]);
        }
    }
    
}
