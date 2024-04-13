/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg5;

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
        int nobreros, opcion = 0, horas, hdobles = 0, htriples = 0, total, pago,hextras;
        System.out.println("Ingrese el numero de obreros de la empresa.");
        nobreros = scan.nextInt();
        System.out.println("Ingrese el salario a los obreros por hora.");
        pago = scan.nextInt();
        do {
            opcion++;
            System.out.println("Obrero " + opcion);
            System.out.println("Ingrese el numeros de horas que trabajo el obrero en la semana.");
            horas = scan.nextInt();
            if (horas > 40) {
                 hextras=horas-40;
                     System.out.println("El numero de horas extras es de: " + hextras);
                hdobles = (horas - 40);
                    hdobles = hdobles * (pago * 2);
                    System.out.println("El valor de la horas extras es de: " + hdobles);
                if (horas > 48) {
                    htriples = (horas - 48);
                    htriples = htriples * (pago * 3);
                    System.out.println("El valor de las horas restantes es de: " + htriples);
                } 
            }                    
            total = (horas * pago) + hdobles + htriples;
            System.out.println("El valor a pagar del obrero " + opcion + " es de: " + total);
        } while (nobreros != opcion);
    }

}
