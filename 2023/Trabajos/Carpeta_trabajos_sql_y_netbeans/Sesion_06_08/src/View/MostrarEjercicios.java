/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Utils.Ejercicios;
import Utils.FunctionString;
/**
 *
 * @author JuanDa
 */
public class MostrarEjercicios {
    public static void main(String[] args) {
    FunctionString fs = new FunctionString();
        Ejercicios fn = new Ejercicios();
        
        fn.InputNumericFahrenheit("Ingresa los grados celsius: ");
        fn.InputNumericKelvin("Ingresa los grados celsius: ");
        fn.InputNumericCelsius("Ingresa los grados Fahrenheit: ");
        fn.InputNumericKelvinF("Ingrese los grados Fahrenheit");
        fn.InputNumericFK("Ingrese los grados Kelvin: ");
    }
}
