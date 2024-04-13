/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg12.pkg4;

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
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese el multiplicando: ");
        int num1 = scan.nextInt();
        System.out.print("Ingrese el multiplicador maximo: ");
        int num2 = scan.nextInt();
        for (int i = 0; i <= num2; i++) {
            System.out.println(num1 + " * " + i + " = " + num1 * i);
        }
    }
    
}
