package UD2.join;

public class Hilo extends Thread{

    private int n;

    public Hilo(String nombre, int n){
        super(nombre);
        this.n = n;
    }

    public void run(){
        for (int i = 1; i <= n; i++) {
            System.out.println(getName()+" : "+i);
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("fin del bucle "+getName());
    }
}
