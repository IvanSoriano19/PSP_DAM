package UD2.ejercicio33;

public class Autobus {
    
    private int velocidad;
    private String matricula;

    public Autobus(String matricula) {
        velocidad = 50;
        this.matricula = matricula;
    }

    
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int nuevavelo) {
		velocidad = nuevavelo;
	}

    public String getMatricula() {
        return matricula;
    }

}
