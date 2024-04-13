/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg11.pkg3;

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
        int clientes = 0, ventas = 0, monto, opcion=0;
        while (opcion!=2){
        System.out.println("menu:");
        System.out.println("1. Ingresar cliente");
        System.out.println("2. Terminar programar.");
        opcion = scan.nextInt();
        switch (opcion) {
            case 1:
                clientes++;
                System.out.println("Ingrese el monto del cliente.");
                monto = scan.nextInt();
                ventas = ventas + monto;
                break;
            case 2:
                System.out.println("El total de ventas del dia es: " + ventas);
                System.out.println("El total de clientes del dia es: "+clientes);
                System.out.println("Programa terminado.");
                break;
            default:
                System.out.println("Opcion no valida");
        }
        }
    }

}
