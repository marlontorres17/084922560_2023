/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg3.pkg12.pkg10;

/**
 *
 * @author Pc-Jhon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long num = 0, num2 = 1, num3;
        for (int i = 1; i < 100; i++) {
            System.out.println(num);
            num3 = num + num2;
            num = num2;
            num2 = num3;
        }
    }
    
}
