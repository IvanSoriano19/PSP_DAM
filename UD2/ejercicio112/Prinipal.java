package UD2.ejercicio112;

public class Prinipal {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("Juan");
        Hilo h2 = new Hilo("Pepe");
        Hilo h3 = new Hilo("Hilo 3");
    
        h1.start();
        h2.start();
        h3.start();
    
        System.out.println("3 Hilos iniciados");
    }
}
