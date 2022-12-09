public class BPA {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(40, 500);

        Persona juan = new Persona("Juan",cuenta);
        Persona pepa = new Persona("Pepa",cuenta);

        juan.start();
        pepa.start();
        try {
            juan.join();
            pepa.join();
        } catch (Exception e) {
            System.out.println("fin del programa");
        }


    }
}
