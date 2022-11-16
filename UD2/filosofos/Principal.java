package UD2.filosofos;

public class Principal {
    public static void main(String[] args) {
        Palillos palillos = new Palillos(5);

		Filosofo p1 = new Filosofo(palillos, 1);
		Filosofo p2 = new Filosofo(palillos, 2);
		Filosofo p3 = new Filosofo(palillos, 3);
		Filosofo p4 = new Filosofo(palillos, 4);
		Filosofo p5 = new Filosofo(palillos, 5);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
    }
}
