public class Persona extends Thread {
    private String nombre;
    private Cuenta cuenta;

    public Persona(String name, Cuenta cuenta) {
        nombre = name;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void run() {
        int dinero;

        for (int i = 0; i < 4; i++) {
//            try {
//                sleep(500);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            dinero = (int) (Math.random() * 501);
            //he creado esta condición para que se intercalen los ingresos y las retiradas
            if (i % 2 == 0) {
                cuenta.ingresar(dinero, getNombre());
            } else {
                cuenta.retirar(dinero, getNombre());
            }
        }
    }
}
