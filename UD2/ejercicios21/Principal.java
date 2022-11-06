package UD2.ejercicios21;

import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_coche = 0;
        String marca_coche = "";
        ArrayList<Coche> lista_coches = new ArrayList<Coche>();

        System.out.println("Introduzca numero de coches a competir:");
        num_coche = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= num_coche; i++) {
            System.out.println("Dime la marca del coche " + i);
            marca_coche = sc.nextLine();
            Coche coche = new Coche(i,marca_coche);
            lista_coches.add(coche);
        }

        System.out.println("Va a empezar la carrera");

        for (Coche coche : lista_coches) {
            coche.start();
        }
    }
}
