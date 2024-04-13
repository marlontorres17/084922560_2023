/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg11.pkg1;
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
        double u1,u2,u3,u4,u5,promedio;
        int nivelan=0,nestudiante=0;
        while(nestudiante!=40){
            nestudiante++;
        System.out.println("Ingrese las calificaciones de las 5 unidades del alumno "+nestudiante);
        u1=scan.nextDouble();
        u2=scan.nextDouble();
        u3=scan.nextDouble();
        u4=scan.nextDouble();
        u5=scan.nextDouble();
        promedio=(u1+u2+u3+u4+u5)/5;
            System.out.println("El promedio del estudiante "+nestudiante+" es de: "+promedio);
        if (promedio<3.0 & promedio>=2.5) {
            nivelan++;
        }           
    }
        System.out.println("El total de estudiantes que nivelan es de: "+nivelan);
}
}
