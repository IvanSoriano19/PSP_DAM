package UD2.ejercicio31;

import java.util.*;

public class Principal{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Contador cont = new Contador(100);

        System.out.println("Contador inicado");
        System.out.println("Dime cuantas veces voy a sumar");
        int suma = sc.nextInt();
        System.out.println("Dime cuantas veces voy a restar");
        int resta = sc.nextInt();

        Hilosuma hsuma = new Hilosuma("Hilo suma", cont, suma);
        Hiloresta hresta = new Hiloresta("Hilo resta", cont, resta);
        hsuma.start();
        hresta.start();

        sc.close();
    }
}