public class BPA {

    public static void main(String[] args) {
        Cuenta c = new Cuenta(40, 500);

        Persona juan = new Persona("Juan",c);
        Persona pepa = new Persona("Pepa",c);

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
