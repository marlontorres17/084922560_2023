/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_matriz4;
import java.util.Scanner;
/**
 *
 * @author srhad
 */
public class Ejercicio_matriz4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int[][] matriz=new int[5][5];
        int[] columna=new int[5];
        int maximo=0;
        int posicion=1;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.println("Ingrese el valor de la fila "+(i+1)+",columna "+(j+1));
                matriz[i][j]=scan.nextInt();
                columna[j]=columna[j]+matriz[i][j];
                maximo=columna[0];
                if(maximo<columna[j]){
                    maximo=columna[j];
                    posicion=j+1;
                }
            }
        }
        System.out.println("La columa con la maximo suma de sus valores es "+posicion);
        System.out.print("El valor de la sumatoria de la columna es: "+maximo);
    }
    
}
