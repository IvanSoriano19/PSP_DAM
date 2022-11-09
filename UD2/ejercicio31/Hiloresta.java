package UD2.ejercicio31;

public class Hiloresta extends Thread{
    private Contador contador;
    private int cantidad;

    public Hiloresta(String n, Contador c, int cantidad) {
        super(n);
        contador = c;
        this.cantidad = cantidad;
    }

    public void run() {
        synchronized(contador){
            for (int i = 0; i < cantidad; i++) {
                contador.resta();
                int valor = contador.valor();
                System.out.println(getName()+" Cantidad "+valor);
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}
