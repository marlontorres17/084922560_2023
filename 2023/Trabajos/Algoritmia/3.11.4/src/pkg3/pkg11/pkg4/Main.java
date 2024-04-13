/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg11.pkg4;

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
        double totalVentas = 0;
        int opcion = 0;
        double cambio;
        while (2 != opcion) {
            System.out.println("Menu:");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Terminar programa.");
            opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el monto de la venta del cliente: ");
                    double monto = scan.nextDouble();
                    double iva = monto * 0.19;
                    double total = monto + iva;
                    System.out.println("IVA: " + iva);
                    System.out.println("Total a pagar: " + total);
                    System.out.println("Ingrese la cantidad recibida del cliente: ");
                    double recibido = scan.nextDouble();
                    if (recibido<total){
                        cambio=0;
                        double deuda;
                        deuda=total-recibido;
                        System.out.println("El cliente queda con una deuda de: "+deuda);
                    }else{
                    cambio = recibido - total;
                    System.out.println("Cambio: " + cambio);
                    }
                    totalVentas = (totalVentas + recibido) - cambio;
                    break;
                case 2:
                    System.out.println("El total de dinero en la caja es de: " + totalVentas);
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
