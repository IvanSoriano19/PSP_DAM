package UD2.ejercicio33;

public class Principal {
    public static void main(String[] args) {
        
        Autobus autobus = new Autobus("1234-BBB");

        Speed acelera = new Speed(autobus, "acelerar");
        Speed frena = new Speed(autobus, "frenar");

        acelera.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        frena.start();
    }
}
