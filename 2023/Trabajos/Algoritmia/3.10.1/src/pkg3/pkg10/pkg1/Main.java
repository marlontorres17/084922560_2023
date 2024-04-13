/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg1;

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
        int opcion;
        double descuento;
        descuento = 0;
        double precio;
        do {
            int numero = (int) (Math.random() * 3) + 1;
            System.out.println("Ingrese el precio de la compra del cliente.");
            precio = scan.nextDouble();
            switch (numero) {
                case 1:
                    System.out.println("El color de la bolita es rojo.");
                    descuento = precio * 0.4;
                    break;
                case 2:
                    System.out.println("El color de la bolita es amarrillo.");
                    descuento = precio * 0.25;
                    break;
                case 3:
                    System.out.println("El color de la bolita es blanco");
                    descuento = precio * 0;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println("El descuento de la compra es: " + descuento);
            System.out.println("El total de la compra es: " + (precio-descuento));
            System.out.println("menu:");
            System.out.println("1. Ingresar otro cliente.");
            System.out.println("2. Cerrar la tienda.");
            opcion = scan.nextInt();
            if (opcion==2){
                System.out.println("Tienda cerrada.");
            }
        } while (opcion!=2);
    }
}
