package ExamenPrimeraEv;

public class Hilo extends Thread{
    
    private Bolsa bolsa;

    public Hilo(Bolsa bolsa){
        super();
        this.bolsa = bolsa;
    }

    @Override
    public void run() {
        try {
            synchronized(bolsa){
                System.out.println("La bolsa no esta llena, esperamos");
                bolsa.wait();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("*********************************");
        System.out.println("La bolsa esta llena con "+bolsa.getSize()+" patatas");
        System.out.println("*********************************");
    }


}
