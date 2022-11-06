package UD2.hola_mundo3;

public class Principal {
    public static void main(String[] args) {
        Hilo h = new Hilo();

        h.start();
        h.esperar();
        h.parar();
    }
}
