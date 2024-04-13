/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg4;
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
        double masa,presion,volumen,temperatura,neumaticos=0;
        int nvehiculos,opcion=0,vehiculo;
        System.out.println("Ingrese el numero de vehiculos.");
        nvehiculos =scan.nextInt();
        do{
            opcion++;
            System.out.println("vehiculo "+opcion);
            System.out.println("Menu:");
            System.out.println("1. Es una motocicleta el vehiculo.");
            System.out.println("2. Es un automovil el vehiculo.");
            vehiculo=scan.nextInt();
            System.out.println("Ingrese la presion,el volumen y la temperatura de los neumaticos.");
            presion=scan.nextDouble();
            volumen=scan.nextDouble();
            temperatura=scan.nextDouble();
            masa= (presion*volumen)/(0.37*(temperatura+460));
            switch (vehiculo){
                case 1:
                    masa=masa*2;
                    break;
                case 2:
                    masa=masa*4;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            neumaticos=((neumaticos+masa)/nvehiculos);
            System.out.println("La masa de aire de los neumaticos del vehiculo es: "+masa);
            System.out.println("El promedio de masa de aire de los neumaticos de los vehiculos es: "+neumaticos);
        }while(opcion!=nvehiculos);
    }
    
}
