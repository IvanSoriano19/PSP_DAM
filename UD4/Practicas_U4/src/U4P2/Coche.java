package U4P2;

public class Coche {
    private String dni;
    private String matricula;
    private String marca;
    private String modelo;
    private String combustible;
    private int fechaMatriculacion;

    private static final long serialVersionUID = 1L;

    public Coche(String dni, String matricula, String marca, String modelo, String combustible, int fechaMatriculacion) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.fechaMatriculacion = fechaMatriculacion;

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(int fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
}
