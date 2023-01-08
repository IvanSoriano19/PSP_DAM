public class Hacker extends Thread {

    public String name;
    public SalaReunions salaReunions;
    public Atac ataque;
    
    public Hacker(String nombre, SalaReunions salaReunions){
        
        name=nombre;
        this.salaReunions=salaReunions;
        ataque = new Atac(nombre);
    }

    public void run(){

        salaReunions.esperar(name);

        ataque.start();

    }

}
