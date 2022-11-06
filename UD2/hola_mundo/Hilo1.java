package UD2.hola_mundo;

public class Hilo1 extends Thread{

    public Hilo1(String nombre) {
        super(nombre);
        System.out.println("\nCreando hilo..."+getName());
    }

    public void run(){
        System.out.println("\nHola me llamo "+getName());
    }
    
}