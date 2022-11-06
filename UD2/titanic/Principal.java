package UD2.titanic;

import java.io.*;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        
        File file_entrada = new File("./UD2/titanic/Titanic.csv");
        Scanner sc = null;
        ArrayList<Persona> lista_personas = new ArrayList<Persona>();

        try {
            String linea;
            sc = new Scanner(file_entrada);
            sc.nextLine();
            while (sc.hasNext()) {
                linea = sc.nextLine();
                String[] partes = linea.split(",");
                Persona persona = new Persona(Integer.parseInt(partes[0]), partes[1], partes[2], Integer.parseInt(partes[3]), partes[4], partes[5].charAt(0));
                lista_personas.add(persona);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        Hilo hilo1 = new Hilo("Primera clase", lista_personas);
        Hilo hilo2 = new Hilo("Segunda clase", lista_personas);
        Hilo hilo3 = new Hilo("Tercera clase", lista_personas);
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (Exception e) {
            e.getMessage();
        }

        System.out.println("Fin del programa");
    }
}
