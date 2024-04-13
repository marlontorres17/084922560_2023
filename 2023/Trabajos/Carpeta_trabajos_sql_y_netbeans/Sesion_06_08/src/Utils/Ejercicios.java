/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author JuanDa
 */
public class Ejercicios {
    private Double numero;

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }
    
    public Double EjerciciosConversionScanner(String mensaje){
        EjerciciosConversion(mensaje, 1);
        return this.getNumero();
    }
    
    private void EjerciciosConversion(String mensaje, int tipo){
        Boolean validar = false;
        FunctionString fs = new FunctionString();

        //Validar que se ingrese el dato correcto
        while (validar == false) {
            try {
                if(tipo==1){
                    this.setNumero(Double.parseDouble(fs.InputScanner(mensaje)));
                }else{
                    this.setNumero(Double.parseDouble(fs.InputJOptionPane(mensaje)));
                }
                validar = true;
            } catch (Exception e) {
                if (tipo==1) {
                    fs.ShowScanner("Ha ingresado un dato no válido. ");
                }else{
                    fs.ShowJOptionPane("Ha ingresado un dato no válido. ");
                }
            }
        }        
    }
    public Double InputNumericFahrenheit(String mensaje){

        EjerciciosConversion(mensaje, 1);
        Double celsius = this.getNumero();

        // Realizar la conversión de Celsius a Fahrenheit
        Double fahrenheit = (celsius * 9 / 5) + 32;

     
        System.out.println(celsius + " grados Celsius son " + fahrenheit + " grados Fahrenheit.");
 return this.getNumero();

   
}
    public Double InputNumericKelvin(String mensaje){
        EjerciciosConversion(mensaje, 1);
        Double celsius = this.getNumero();

        // Realizar la conversión de Celsius a Fahrenheit
        Double Kelvin =celsius + 273.15;

     
        System.out.println(celsius + " grados Celsius son " + Kelvin + " grados Fahrenheit.");


    return this.getNumero();
    }
    public Double InputNumericCelsius(String mensaje){
        EjerciciosConversion(mensaje, 1);
        Double fahrenheit = this.getNumero();
        Double celsius=(fahrenheit - 32) * 5 / 9;
        System.out.println(fahrenheit + "grandos Fahrenheit son "+celsius + " grados Celsius");
        return this.getNumero();
    }
    
    public Double InputNumericKelvinF(String mensaje){
        EjerciciosConversion(mensaje, 1);
        Double fahrenheit = this.getNumero();
        Double celsius = (fahrenheit - 32) * 5 / 9;
        Double Kelvin=celsius + 273.15;
        System.out.println(fahrenheit + "grandos Fahrenheit son "+Kelvin + " grados Celsius");
        return this.getNumero();
    }
    public Double InputNumericFK(String mensaje){
        EjerciciosConversion(mensaje, 1);
        Double Kelvin = this.getNumero();
        Double celsius = Kelvin - 273.15;
        Double fahrenheit = (celsius* 9/5)+32;
        System.out.println(Kelvin + "grandos Kelvin son "+fahrenheit+ " grados Fahrenheit");
        return this.getNumero();
    }
    
     public Double InputNumericKC(String mensaje){
        EjerciciosConversion(mensaje, 1);
        Double Kelvin = this.getNumero();
        Double celsius = Kelvin - 273.15;
        System.out.println(Kelvin + "grandos Kelvin son "+celsius+ " grados Fahrenheit");
        return this.getNumero();
    
    }
}

