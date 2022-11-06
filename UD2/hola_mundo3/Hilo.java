package UD2.hola_mundo3;

public class Hilo extends Thread{
    
private boolean pararHilo = false;

public void run(){
    while (!pararHilo) {
        System.out.println("En el hilo");
    }
}

public void esperar(){
    try {
        Thread.sleep(1000);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void parar(){
    pararHilo = true;
    System.out.println("\nHilo parado");
}

}
