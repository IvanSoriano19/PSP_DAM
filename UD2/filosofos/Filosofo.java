package UD2.filosofos;


public class Filosofo extends Thread{
    
    private Palillos palillos;
    private int filo;
    private int nFilo;

    public Filosofo(Palillos palillos, int num) {
        this.palillos = palillos;
        filo = num;
        nFilo = filo - 1;
    }

    public void run() {
        while (true) {
            pensando();
            palillos.cogerPalillos(nFilo);
            comiendo();
            System.out.println("Filosofo "+filo+" deja de comer, tenedores libres "+(palillos.palilloIzq(nFilo) + 1) + ", " +(palillos.palilloDer(nFilo) + 1));
            palillos.dejarPalillos(nFilo);
        }
    }

    public void pensando(){
        System.out.println("Filosofo "+filo+" esta PENSANDO");
        try {
            sleep(1000);
        } catch (Exception e) {
        }
    }

    public void comiendo(){
        System.out.println("Filosofo "+filo+" esta COMIENDO");
        try {
            sleep(1000);
        } catch (Exception e) {
        }
    }
}
