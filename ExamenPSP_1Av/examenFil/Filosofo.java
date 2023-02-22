// package ExamenPSP_1Av.examenFil;

public class Filosofo extends Thread{

    private Mesa mesa;
    private int filosofo;
    private int iFilosofo;
    
    public Filosofo (Mesa mesa, int filosofo){
        this.mesa = mesa;
        this.filosofo = filosofo;
        this.iFilosofo = filosofo -1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(iFilosofo);
            pensando();
            mesa.cogerPalillos(iFilosofo);
            comiendo();
            System.out.println("Filosofo "+ filosofo +" deja de comer tenedore libres "+mesa.palilloIzq(iFilosofo +1)+", "+mesa.palilloDer(iFilosofo +1));
            mesa.dejarPalillos(iFilosofo);
        }
    }

    public void pensando(){
        System.out.println("Filosofo "+ filosofo+" esta pensando");
        try {
            sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void comiendo(){
        System.out.println("Filosofo "+ filosofo+" esta comiendo");
        try {
            sleep(5000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
