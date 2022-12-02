public class Persona {
    private String nombre;
    private Cuenta cuenta;

    public Persona(String name, Cuenta cuenta){
        nombre = name;
        int dinero;
        for (int i = 0; i < 4; i++) {
            dinero = (int) (Math.random()*501);
            if (i%2==0){
                cuenta.ingresar(dinero,name);
            }else{
                System.out.println("impar");
            }
        }

        // hay que sincronizar las personas para
        // que cuando uno no pueda ingresar, se
        // espere a se retire dinero para que pueda pueda ingresar dinero.

    public String getNombre() {
        return nombre;
    }



}
