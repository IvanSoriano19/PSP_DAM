package UD2.banco;

public class SacarDinero extends Thread{
    
    private Cuenta cuenta;
    String nombre;

    public SacarDinero(String n, Cuenta c) {
        nombre = n;
        cuenta = c;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            cuenta.sacarDinero(10, nombre);
        }
    }
    
}
