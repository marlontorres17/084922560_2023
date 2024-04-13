/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg13.pkg5;

import java.util.Scanner;

/**
 *
 * @author Ambiente 203-9
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("Ingrese el numero hasta que se almacena");
        n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        for (int i=1;i<n;i++){
            if (a[i]!=0){
                for (int j=i+1;j<n;j++){
                    if (a[j]%a[i]==0){
                        a[j]=0;
                    }
                }
            }
        }
        System.out.println("Los numeros primos son:");
        for (int i=1;i<n;i++){
            if (a[i]!=0){
                System.out.println("- "+a[i]);
            }
        }
        
    }
}
