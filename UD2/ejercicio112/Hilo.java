package UD2.ejercicio112;

public class Hilo extends Thread{
    
    public Hilo(String nombre) {
        super(nombre);
    }
    
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()+" con el valor: "+i);
        }
    }
}
