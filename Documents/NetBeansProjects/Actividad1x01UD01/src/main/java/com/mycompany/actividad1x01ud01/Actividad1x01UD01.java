/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad1x01ud01;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Actividad1x01UD01 {

    public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
				
		//Pide el primer numero por teclado
			System.out.println("Dime un número: ");
			int numero1;
			numero1 = teclado.nextInt();
			
		//Pide el segundo número por teclado
			System.out.println("Dime un segundo número: ");
			int numero2;
			numero2 = teclado.nextInt();
			
		//Pide un tercer número por teclado
			System.out.println("Dime un tercer número: ");
			int numero3;
			numero3 = teclado.nextInt();
					
		//Sacar los números
			System.out.println("El primer número elegido es: " + numero1);
			System.out.println("El segundo número elegido es: " + numero2);
			System.out.println("El tercer nfmero elegido es: " + numero3);
			
			teclado.close();

	}
}
