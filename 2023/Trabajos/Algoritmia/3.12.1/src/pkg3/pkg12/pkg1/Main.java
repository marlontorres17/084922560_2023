/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg12.pkg1;

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
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa un número: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
 
            System.out.println(i);
        }
    }
}
