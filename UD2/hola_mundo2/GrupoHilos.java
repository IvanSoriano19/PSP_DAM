package UD2.hola_mundo2;

public class GrupoHilos extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().toString());
    }
    
}