package ExamenPrimeraEv;

public class Principal {
    public static void main(String[] args) {
        Bolsa bolsa = new Bolsa();

        if (bolsa.getSize() == 1) {
            System.out.println("Bolsa no esta llena, tiene " + bolsa.getSize() + " patata");
        } else {
            System.out.println("Bolsa no esta llena, tiene " + bolsa.getSize() + " patatas");
        }

        Hilo hilo = new Hilo(bolsa);
        hilo.start();

        for (int i = 0; i <= 5; i++) {
            Patata patata = new Patata();
            try {
                synchronized(bolsa){
                    Thread.sleep(1000);
                    if (bolsa.estadoBolsa()) {
                        bolsa.notify();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            if(bolsa.getSize()!= 5){
                bolsa.addPatatas(patata);

                if (bolsa.getSize() == 1) {
                    System.out.println("Bolsa no esta llena, añadimos " + bolsa.getSize() + " patata");
                } else {
                    System.out.println("Bolsa no esta llena, añadimos " + bolsa.getSize() + " patatas");
                }
            }
        }
    }
}
