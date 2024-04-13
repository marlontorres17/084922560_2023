/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda.enano.s.a;
import java.util.Scanner;
/**
 *
 * @author Ambiente 209-1
 */
public class TIENDAENANOSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner scan = new Scanner(System.in);
       double total = 0;
        char seguir;

        do {
            System.out.print("Ingrese el precio del artículo: ");
            double precio = scan.nextDouble();

            System.out.print("¿La etiqueta del artículo es roja? (s/n): ");
            char etiqueta = scan.next().charAt(0);

            if (etiqueta == 's') {
                total += precio * 0.8;
            } else {
                total += precio;
            }

            System.out.print("¿Desea seguir comprando? (s/n): ");
            seguir = scan.next().charAt(0);

        } while (seguir == 's');

        System.out.println("El total a pagar es: $" + total);
    }
}