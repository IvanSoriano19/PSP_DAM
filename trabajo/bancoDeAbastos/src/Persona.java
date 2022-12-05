public class Persona extends Thread{
    private String nombre;
    private Cuenta cuenta;

    public Persona(String name, Cuenta cuenta) {
        nombre = name;
        this.cuenta = cuenta;
    }

    public void run(){
        int dinero;
        for (int i = 0; i < 4; i++) {
            dinero = (int) (Math.random() * 501);
            if (i % 2 == 0) {
//                System.out.println(nombre+" va a ingresar "+dinero+" .(actualmente hay "+cuenta.getDinero()+" euros).");
                cuenta.ingresar(dinero, nombre);
            } else {
//                System.out.println(nombre+" va a retirar "+dinero+" .(actualmente hay "+cuenta.getDinero()+" euros).");
                cuenta.retirar(dinero, nombre);
            }
        }
    }
}
