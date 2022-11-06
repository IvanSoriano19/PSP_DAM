package UD2.titanic;

public class Persona {

    int clase, edad;
    String apellido, nombre, sitio;
    char sobrevivido;


    public Persona(int clase, String apellido, String nombre, int edad, String sitio,  char sobrevivido) {
        this.clase = clase;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.sitio = nombre;
        this.sobrevivido = sobrevivido;
    }


    public int getClase() {
        return clase;
    }


    public char getSobrevivido() {
        return sobrevivido;
    }

    
}
