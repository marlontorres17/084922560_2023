/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg3;

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
        int ct1 = 0, ct2 = 0, ct3 = 0, ct4 = 0, ct5 = 0, precio, edad, opcion;
        double descuento = 0;
        System.out.println("Ingrese el precio de los asientos.");
        precio = scan.nextInt();
        do {
            System.out.println("Ingrese la edad del cliente.");
            System.out.println("1. El cliente tiene entre 5 a 14 años.");
            System.out.println("2. El cliente tiene entre 15 a 19 años.");
            System.out.println("3. El cliente tiene entre 20 a 45 años.");
            System.out.println("4. El cliente tiene entre 46 a 65 años.");
            System.out.println("5. El cliente tiene 66 o mas años.");
            System.out.println("6. El cliente tiene menos de 5 años.");
            edad = scan.nextInt();
            switch (edad) {
                case 1:
                    descuento = 0.35 * precio;
                    ct1 = (int) (ct1 + descuento);
                    break;
                case 2:
                    descuento = 0.25 * precio;
                    ct2 = (int) (ct2 + descuento);
                    break;
                case 3:
                    descuento = 0.1 * precio;
                    ct3 = (int) (ct3 + descuento);
                    break;
                case 4:
                    descuento = 0.25 * precio;
                    ct4 = (int) (ct4 + descuento);
                    break;
                case 5:
                    descuento = 0.35 * precio;
                    ct5 = (int) (ct5 + descuento);
                    break;
                case 6:
                    System.out.println("El cliente tiene menos de 5 años no puede ingresar al teatro.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println("El descuento del cliente es: " + descuento);
            System.out.println("El valor a pagar del cliente es: " + (precio - descuento));
            System.out.println("El dinero que deja percibir el tatro en la categoria 1 es: " + ct1);
            System.out.println("El dinero que deja percibir el tatro en la categoria 2 es: " + ct2);
            System.out.println("El dinero que deja percibir el tatro en la categoria 3 es: " + ct3);
            System.out.println("El dinero que deja percibir el tatro en la categoria 4 es: " + ct4);
            System.out.println("El dinero que deja percibir el tatro en la categoria 5 es: " + ct5);
            System.out.println("Menu:");
            System.out.println("1. Ingresar otro cliente.");
            System.out.println("2. Cerrar Teatro.");
            opcion = scan.nextInt();
            if (opcion == 2) {
                System.out.println("Teatro cerrado.");
            }
        } while (opcion != 2);
    }

}
