public class Cuenta {

    private int dinero, maxDinero;

    public Cuenta(int maxDinero){
        dinero = 40;
        this.maxDinero = maxDinero;
    }

    public int getDinero() {
        return dinero;
    }

    public void ingresar(int newDinero , String nombre){
        dinero += newDinero;
        System.out.println(nombre+"=> ha ingresado "+ newDinero+" ahora hay "+dinero);
    }

}
