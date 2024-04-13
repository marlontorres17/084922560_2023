/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg11.pkg2;
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
        int voto,votantes=0,c1=0,c2=0,c3=0;
        while(votantes!=2500000){
            votantes++;
            System.out.println("Candidato por el que vota.");
            System.out.println("1. Candidato 1.");
            System.out.println("2. Candidato 2.");
            System.out.println("3. Candidato 3.");
            voto=scan.nextInt();
            switch (voto){
                case 1:
                    c1=c1+1;
                    break;
                case 2:
                    c2=c2+1;
                    break;
                case 3:
                    c3=c3+1;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        System.out.println("El total de votos al candidato 1 es: "+c1);
        System.out.println("El total de votos al candidato 2 es: "+c2);
        System.out.println("El total de votos al candidato 3 es: "+c3);
    }
    
}
