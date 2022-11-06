package UD2.ejercicio_menu;

import java.io.File;
import java.io.FileWriter;

public class Principal {
    public static void main(String[] args) {
        File primeros = new File("./UD2/ejercicio_menu/primeros.txt");
        File segundos = new File("./UD2/ejercicio_menu/segundos.txt");
        File postres = new File("./UD2/ejercicio_menu/postres.txt");
        FileWriter file_primeros = null;
        FileWriter file_segundos = null;
        FileWriter file_postres = null;

        try {
            primeros.createNewFile();
            file_primeros = new FileWriter(primeros);
            segundos.createNewFile();
            file_segundos = new FileWriter(segundos);
            postres.createNewFile();
            file_postres = new FileWriter(postres);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ThreadGroup grupo = new ThreadGroup("Menu diario");

        Hilo h = new Hilo(file_primeros, file_segundos, file_postres);
        Thread h1 = new Thread(grupo, h, "Hilo1");
        Thread h2 = new Thread(grupo, h, "Hilo2");
        Thread h3 = new Thread(grupo, h, "Hilo3");
        h1.start();
        h2.start();
        h3.start();
    }
}
