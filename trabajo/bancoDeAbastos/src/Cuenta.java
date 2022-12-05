public class Cuenta{

    private int dinero, maxDinero;
    private Persona persona;

    public Cuenta(int dineroInicial, int maxDinero){
        dinero = dineroInicial;
        this.maxDinero = maxDinero;
    }

    //metodo para obtener el dinero
    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    //metodo para ingresar dinero sincronizado
    public synchronized void ingresar(int newDinero , String nombre) {

        int dinero2 = getDinero();
        dinero2 += newDinero;
        if (dinero2 > maxDinero){
            System.out.println("Se han intentado ingresar "+newDinero+", pero no se ha podido porque el saldo de la cuenta es de "+getDinero());
//            System.out.println("\nintento de suma "+newDinero);
//            System.out.println(nombre);
//            System.out.println("para");
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("\nSe va a ingresar dinero, dinero actual "+getDinero());
            dinero += newDinero;
            setDinero(dinero);
            System.out.println(nombre+" => ha ingresado "+ newDinero+" ahora hay "+getDinero());
            notify();

        }
    }
    //metodo para retirar dinero sincronizado
    public synchronized void retirar(int newDinero , String nombre) {
        int dinero2 = getDinero();
        dinero2 -= newDinero;

        if (dinero2 < 0){
            System.out.println("Se han intentado ingresar "+newDinero+", pero no se ha podido porque el saldo de la cuenta es de "+getDinero());
//            System.out.println("\nintento de resta "+newDinero);
//            System.out.println(nombre);
//            System.out.println("para");
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("\nSe va a retirar dinero, dinero actual "+getDinero());
            dinero -= newDinero;
            setDinero(dinero);
            System.out.println(nombre+" => ha retirado "+ newDinero+" ahora hay "+getDinero());
            notify();
        }
    }



}
