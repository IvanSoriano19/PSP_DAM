public class SalaReunions {

    public SalaReunions() {

    }

    public boolean neo = false;

    public synchronized void esperar(String name) {

        System.out.println(name + " entra a la sala de reuniones");
        // si llega Neo notifica a todos los que esten wait y pone el boolean a true por
        // los que puedan llegar mas tarde
        if (name.equals("Neo")) {
            System.out.println("Ya ha llegado Neo");
            notifyAll();
            neo = true;
        }
        // creo un booleano para saber si ha llegado neo, y si esta a true no entra en
        // la condicion
        // pero si esta a false entra y hace un wait a ese hilo
        if (!neo) {
            try {
                System.out.println("Espero a Neo");
                this.wait();
            } catch (Exception e) {
            }
        }

    }
}