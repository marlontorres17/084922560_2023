/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_matriz2;
import java.util.Scanner;
/**
 *
 * @author srhad
 */
public class Ejercicio_matriz2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
         int[][] matriz=new int[5][5];
         int mayor=0,fila=0,columna=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.println("Ingrese el número de la fila "+(i+1)+" y la columna "+(j+1));
                matriz[i][j]=scan.nextInt();
                mayor=matriz[0][0];
                if (mayor<matriz[i][j]){
                    mayor=matriz[i][j];
                    fila=i+1;
                    columna=j+1;
                }
            }
        }
        System.out.println("El numero mayor de la matriz es: "+mayor);
        System.out.println("La posicion del numero es la fila "+fila+" y la columna "+columna);
    }
    
}
