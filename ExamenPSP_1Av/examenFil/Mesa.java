// package ExamenPSP_1Av.examenFil;

public class Mesa extends Thread{
    private boolean[] palillos;
    
    public Mesa() {
        this.palillos = new boolean[6];
    }

    public int palilloIzq(int i){
        return i;
    }

    public int palilloDer(int i){
        // System.out.println(this.palillos.length);
        if(i == 0){
            return this.palillos.length - 1 ;
        }else{
            return i - 1;
        }
    }

    public synchronized void cogerPalillos(int filosofo){
        while (palillos[palilloIzq(filosofo)] || palillos[palilloDer(filosofo)]) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        palillos[palilloIzq(filosofo)] = true;
        palillos[palilloDer(filosofo)] = true;
    }

    public synchronized void dejarPalillos(int filosofo){
        
        palillos[palilloIzq(filosofo)] = false;
        palillos[palilloDer(filosofo)] = false;
        notifyAll();
    }
}
