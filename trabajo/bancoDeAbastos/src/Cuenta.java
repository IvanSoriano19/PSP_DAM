public class Cuenta {

    private int dinero, maxDinero;

    public Cuenta(int dineroInicial, int maxDinero) {
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
    public synchronized void ingresar(int newDinero, String nombre) {
        System.out.println("\nSe va a ingresar dinero, dinero actual " + getDinero());

        int dineroActual = obtenerDinero(newDinero, "ingresar");

        while (dineroActual > maxDinero) {
            dineroActual = obtenerDinero(newDinero, "ingresar");
            if (dineroActual<maxDinero){
                notifyAll();
                break;
            }
            System.out.println(nombre + " ha intentado ingresar " + newDinero + ", pero no se ha podido porque el saldo de la cuenta es de " + getDinero());
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dineroActual<maxDinero){
            notifyAll();
        }
        dinero += newDinero;
        setDinero(dinero);
        System.out.println(nombre + " => ha ingresado " + newDinero + " ahora hay " + getDinero());
    }

    //metodo para retirar dinero sincronizado
    public synchronized void retirar(int newDinero, String nombre) {
        System.out.println("\nSe va a retirar dinero, dinero actual " + getDinero());

        int dineroActual = obtenerDinero(newDinero, "retirar");

        while (dineroActual < 0) {
            dineroActual = obtenerDinero(newDinero, "retirar");
            if (dineroActual>0){
                notifyAll();
                break;
            }
            System.out.println(nombre + " ha intentado retirar " + newDinero + ", pero no se ha podido porque el saldo de la cuenta es de " + getDinero());
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dineroActual>0){
            notifyAll();
        }
        dinero -= newDinero;
        setDinero(dinero);
        System.out.println(nombre + " => ha retirado " + newDinero + " ahora hay " + getDinero());


    }

    // este metodo lo utilizo como auxiliar para comprobar si se puede sumar y que no sobrepase o baje de los limites de la cuenta
    public int obtenerDinero(int dinero, String metodo) {
        int dineroActual = getDinero();

        if (metodo.equals("ingresar".trim())) {
            dineroActual += dinero;
        }

        if (metodo.equals("retirar".trim())) {
            dineroActual -= dinero;
        }
        return dineroActual;
    }
}









