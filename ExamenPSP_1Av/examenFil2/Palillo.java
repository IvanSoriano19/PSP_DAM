package ExamenPSP_1Av.examenFil2;

import java.net.SocketTimeoutException;

public class Palillo {
    private int id;
    private boolean libre = true;

    public Palillo(int id) {
        this.id = id;
    }

    public synchronized void cogerTenedor(int i) throws InterruptedException{
        while (!libre) {
            wait();
        }
        System.out.println("Filosofo "+i+" coge el palillo "+ id);
        libre = false;
    }

    public synchronized void dejarTenedor(int i) throws InterruptedException{
        System.out.println("Filosofo "+i+" deja el palillo "+ id);
        libre = true;
        notify();
    }
}
