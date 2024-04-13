/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg12.pkg2;

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
        int a, b, c;
        System.out.println("escribir dos numeros");
        a = scan.nextInt();
        b = scan.nextInt();
        c = a;
        for (int i = 1; i < b; i++) {
            System.out.println(a + "+" + c);
            a = a + c;
        }
        System.out.println("el producto de los dos numeros es: " + a);
    }
    
}
