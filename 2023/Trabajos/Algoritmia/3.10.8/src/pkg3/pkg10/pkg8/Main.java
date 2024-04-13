/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg8;
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
        Scanner scan=new Scanner(System.in);
        double precio,opcion,descuento=0,total=0;
        int etiqueta;
        do{
        System.out.println("Ingrese el valor del articulo.");
        precio=scan.nextDouble();
        System.out.println("¿El articulo tiene etiqueta roja?");
        System.out.println("1. Si.");
        System.out.println("2. No.");
        etiqueta=scan.nextInt();
        switch (etiqueta){
            case 1:
                descuento=0.2;
                break;
            case 2:
                descuento=0;
                break;
            default:
                System.out.println("Opcion no valida");
        }
        precio=precio-(descuento*precio);
        total=total+precio;
        System.out.println("Menu:");
        System.out.println("1. Continuar con la compra.");
        System.out.println("2. Terminar compra.");
        opcion=scan.nextDouble();
        if (opcion==2){
            System.out.println("El total de la compra es: "+total);
            System.out.println("Compra finalizada.");
        }
    }while(opcion!=2);
    }
}
