package UD2.join;

public class Principal {
    public static void main(String[] args) {
        Hilo h1 = new Hilo("pepe", 2);
        Hilo h2 = new Hilo("juan", 3);

        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        } catch (Exception e) {
            System.out.println("fin del programa");
        }
    }
}
