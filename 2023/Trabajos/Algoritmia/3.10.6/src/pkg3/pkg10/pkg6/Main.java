/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg6;

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
        int pgallina, agallinas, nhuevos, ngallinas, opcion = 0, promedio;
        double precio, calidad, ctotal = 0;
        System.out.println("Ingrese el numero de gallinas.");
        ngallinas = scan.nextInt();
        do {
            opcion++;
            System.out.println("Gallina " + opcion);
            System.out.println("Ingrese el peso, la altura y el numero de huevos que pone la gallina.");
            pgallina = scan.nextInt();
            agallinas = scan.nextInt();
            nhuevos = scan.nextInt();
            calidad = (pgallina * agallinas) / nhuevos;
            System.out.println("La calidad de la gallina es: " + calidad);
            ctotal = ctotal + calidad;
        } while (ngallinas != opcion);
        promedio = (int) (ctotal / ngallinas);
        System.out.println("El promedio de la calidad de la gallinas es de: " + promedio);
        if (promedio >= 15) {
            if (promedio > 8 & promedio < 15) {
                if (promedio <= 8) {
                    precio = 0.8 * promedio;
                    System.out.println("El precio de venta por cada kilo de huevo es: " + precio);
                }
                precio = 1 * promedio;
                System.out.println("El precio de venta por cada kilo de huevo es: " + precio);
            }
            precio = 1.2 * promedio;
            System.out.println("El precio de venta por cada kilo de huevo es: " + precio);
        }
    }
}
