package ExamenPSP_1Av.examenFil2;

public class Filosofo extends Thread{
    private int id;
    private Palillo izq, der;

    public Filosofo(int id , Palillo izq, Palillo der) {
        this.id=id;
        this.izq=izq;
        this.der=der;
    }

    public void run() {
        while (true) {
            try {
                izq.cogerTenedor(id);
                der.cogerTenedor(id);
                
                izq.dejarTenedor(id);
                der.dejarTenedor(id);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }
}
