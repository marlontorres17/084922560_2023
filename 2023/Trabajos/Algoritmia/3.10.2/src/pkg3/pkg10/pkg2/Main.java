/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg2;
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
        Scanner scan=new Scanner (System.in);
        int precio,cantidad,valor,total =0,opcion;
        do{
        System.out.println("Ingrese el precio del articulo.");
        precio = scan.nextInt();
        System.out.println("Ingrese la cantidad que va comprar del articulo.");
        cantidad = scan.nextInt();
        valor= (precio*cantidad);
        if (cantidad==1){
        System.out.println("El valor a pagar por el articulo es: "+valor);
        }else{
            System.out.println("El valor a pagar por los articulos es: "+valor);
        }
        total=(total+valor);
        System.out.println("El valor total de la compra es: "+total);
        System.out.println("menu:");
        System.out.println("1. Ingresar otro articulo.");
        System.out.println("2. Terminar compra.");
        opcion = scan.nextInt();
        if (opcion==2){
            System.out.println("Compra terminada.");
        }
        }while(opcion!=2);
    }
    
}
