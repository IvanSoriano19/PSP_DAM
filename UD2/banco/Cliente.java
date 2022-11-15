package UD2.banco;

public class Cliente {

    private String nombre;
    private int edad;
    private char nacionalidad;

    public Cliente(String nombre, int edad, char nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public void info_cliente() {
		System.out.println("\t-"+nombre+" (espanol, "+nacionalidad+"), "+edad+"anos");
	}

	public String getNombre() {
		return nombre;
	}


    


}
