package UD2.vector;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Espacio> vectorEspacios = new ArrayList<Espacio>();

        System.out.println("Dime el numero minimo");
        int min = sc.nextInt();
        System.out.println("Dime el numero maximo");
        int max = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            Espacio espacio = new Espacio();
            vectorEspacios.add(espacio);
        }

        Hilo1 h1 = new Hilo1("hilo1", max, min, vectorEspacios);
        Hilo1 h2 = new Hilo1("hilo2", max, min, vectorEspacios);
        h1.start();
        h2.start();

        sc.close();
    }
}
