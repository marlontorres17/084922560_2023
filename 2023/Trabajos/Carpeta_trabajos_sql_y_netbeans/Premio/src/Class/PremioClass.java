/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.util.Objects;

/**
 *
 * @author JuanDa
 */
public class PremioClass {
    
   
    //ejercicio 1
    public static boolean Mayor5(Double num){
        return num > 5;
    }
    //ejercicio 2
    public static boolean CuadradoMayor5000(Double num){
        return (num*num)>5000;
    }
    //ejercicio 3
    public static  Double valorAbsoluto(Double num){
        return Math.abs(num);
    }
    //ejercicio 4
 public static String Positividad(Double num) {
        if (positivoNegativo(num)) {
            return "positivo";
        } else {
            return "negativo";
        }
    }

    public static boolean positivoNegativo(Double num) {
        return num >= 0;
    }
    
    // ejercicio 5
    public static boolean Mayor200(Double num){
        return num  >200;
    }
    //ejercicio 6
    public static boolean rangoNum(Double num){
        return num >= 50 && num<=100;
    }
    
    //ejercicio 7
    public static boolean ParImpar(Double num){
        return num % 2==0;
    }
    
    //ejercicio 8
    
    public static void obtenerPar(Double num){
        if(ParImpar(num)){
            System.out.println("Es par");
        }else{
            System.out.println("Es impar");
        }
         if(positivoNegativo(num)){
             System.out.println("Es positivo");
    }  else{
             System.out.println("Es negativo");
         }
    
   
    
    
    
    }
    //ejercicio 10d
    public static String MayorMenor(int num1, int numero2){
        if(Objects.equals(num1, numero2)){
            return "Los numeros son iguales";
        }else if(num1>numero2){
            return "El numero " +num1 +"es mayor al " +numero2;
        }else{
            return "El numero  "+numero2 +"es mayor al  "+num1;
        }
        
    }
   
}
