/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Entity.education.Promedio25Porcentaje;
import Utils.FunctionNumeric;
import Utils.FunctionString;



/**
 *
 * @author JuanDa
 */
public class Mostrar {
    public static void main(String[] args) {
        FunctionNumeric fn = new FunctionNumeric();
        FunctionString fs = new FunctionString();
         Promedio25Porcentaje P = new Promedio25Porcentaje();
         
         
         P.Promedio25();
         fs.ShowScanner(P.getCosto());
         
         
        
    }
    
}
