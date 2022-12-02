public class Cuenta {

    private int dinero, maxDinero;
    private Persona persona;

    public Cuenta(int maxDinero){
        dinero = 40;
        this.maxDinero = maxDinero;
    }

    public int getDinero() {
        return dinero;
    }

//    @Override
//    public void run() {
//        ingresar();
//    }

    public void ingresar(int newDinero , String nombre) {
        int dinero2 = dinero;
        dinero2 += newDinero;
        if (dinero2 > maxDinero){
//            try {
//                wait();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            System.out.println(newDinero);
            System.out.println("para");
        }else {
            System.out.println("Se va a ingresar dinero, dinero actual "+dinero);
            dinero += newDinero;
            System.out.println(nombre+" => ha ingresado "+ newDinero+" ahora hay "+dinero);
        }
    }

    public void retirar(new)

}
