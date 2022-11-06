package UD2.hola_mundo;

public class Principal{

    public static void main(String[] args) {
        Hilo1 h = new Hilo1("pepe");
        h.start();
        Hilo1 h2 = new Hilo1("juan");
        h2.start();
    }
}