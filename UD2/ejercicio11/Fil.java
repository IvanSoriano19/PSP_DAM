package UD2.ejercicio11;

public class Fil extends Thread{
    
public Fil(String nombre) {
    super(nombre);
}

public void run(){
    for (int i = 0; i < 5; i++) {
        System.out.println(getName()+" con el valor: "+i);
    }
}

public static void main(String[] args) {
    Fil h1 = new Fil("Juan");
    Fil h2 = new Fil("Pepe");
    Fil h3 = new Fil("Hilo 3");

    h1.start();
    h2.start();
    h3.start();

    System.out.println("3 Hilos iniciados");
}
}
