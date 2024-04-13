/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg10.pkg7;

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
        Scanner scan = new Scanner(System.in);
        double ndiputas, dfavor=0, dcontra=0, dopinar=0, pdfavor, pdcontra, pdopinar;
        int opcion=0,encuesta;
        System.out.println("Ingrese el numero de diputados.");
        ndiputas = scan.nextDouble();
       do{
           opcion++;
           System.out.println("Encuesta sobre el Tratado del Libre Comercio.");
           System.out.println("1. a favor.");
           System.out.println("2. en contra.");
           System.out.println("3. no opina.");
           encuesta=scan.nextInt();
           switch (encuesta){
               case 1:
                   dfavor=dfavor+1;
                   break;
               case 2:
                   dcontra=dcontra+1;
                   break;
               case 3:
                   dopinar=dopinar+1;
                   break;
               default:
                   System.out.println("Opcion no valida.");
           }
       }while(ndiputas!=opcion);
        pdfavor=(dfavor/ndiputas)*100;
        pdcontra=(dcontra/ndiputas)*100;
        pdopinar=(dopinar/ndiputas)*100;
        System.out.println("El porcentaje de diputados a favor es de: "+pdfavor);
       System.out.println("El porcentaje de diputados en contra es de: "+pdcontra);
       System.out.println("El porcentaje de diputados que se abstienen a opinar es de: "+pdopinar);
    }

}
