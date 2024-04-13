/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Class.PremioClass;
import java.util.Scanner;

/**
 *
 * @author JuanDa
 */
public class PremioView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio 1 
        System.out.println("Ingrese un numero real: ");
        Double num = scanner.nextDouble();
        if (PremioClass.Mayor5(num)) {
            System.out.println("Es mayor que 5.");
        } else {
            System.out.println("Es menor que 5.");
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercico2
        System.out.println("ejercicio cuadrado");
        System.out.println("Ingrese un numero real:");
        Double num2 = scanner.nextDouble();
        if (PremioClass.CuadradoMayor5000(num2)) {
            System.out.println("El cuadrado es mayor que 5000");
        } else {
            System.out.println("El cuadrado es menor que 5000");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio3
        System.out.println("Ejercicio absoluto");
        System.out.println("Ingrese un numero: ");
        Double numAbsoluto = scanner.nextDouble();
        Double valorAbsoluto = PremioClass.valorAbsoluto(numAbsoluto);
        System.out.println("El valor absoluto es: " + valorAbsoluto);
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio4
        System.out.println("Ejercicio positivo negativo");
        System.out.println("Ingrese un numero: ");
        Double numeroPyN = scanner.nextDouble();
        String PositivoyNegativo = PremioClass.Positividad(numeroPyN);
        System.out.println("El numero es: " + PositivoyNegativo);
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio5
        System.out.println("Ejercicio Mayor a 200");
        System.out.println("Ingrese un numero: ");
        Double Numero200 = scanner.nextDouble();
        if (PremioClass.Mayor200(Numero200)) {
            System.out.println("Es mayor a 200");
        } else {
            System.out.println("Es menor a 200");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio 6
        System.out.println("Ejercicio rango 50-100");
        System.out.println("Ingrese un numero");
        Double Rango = scanner.nextDouble();
        if (PremioClass.rangoNum(Rango)) {
            System.out.println("El numero esta en el rago de 50 y 100");
        } else {
            System.out.println("No esta en el rango de 50 y 100");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio 7
        System.out.println("Ejercicio par o impar");
        System.out.println("Ingrese un numero");
        Double ParoImpar = scanner.nextDouble();
        if (PremioClass.ParImpar(ParoImpar)) {
            System.out.println("El numero es par");
        } else {
            System.out.println("El numero es impar");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio 8
        System.out.println("Ejercicio par o impar y si es negativo o positivo");
        System.out.print("Ingrese un número: ");
        double numeroParimpar = scanner.nextDouble();

        PremioClass.obtenerPar(numeroParimpar);
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio 9
        System.out.println("Ejercicio rango 200-300");
        System.out.println("Ingresa un numero");
        Double Ejercicio9 = scanner.nextDouble();

        if (Ejercicio9 >= 200 && Ejercicio9 <= 300) {
            System.out.println("El número está dentro del rango 200-300.");
            if (PremioClass.ParImpar(Ejercicio9)) {
                System.out.println("El número es par.");
            } else {
                System.out.println("El número es impar.");
            }
        } else {
            System.out.println("El número está fuera del rango 200-300.");
        }
        System.out.println("------------------------------------------------------------------------------------------------------------");
        //ejercicio 10
        System.out.println("Ejercicio Mayor menor");
        System.out.println("Ingresa el numero 1");
        int num1 = scanner.nextInt();
        System.out.println("Ingresa el numero 2");
        int nummero2 = scanner.nextInt();

        System.out.println(PremioClass.MayorMenor(num1, nummero2));
    }
}
