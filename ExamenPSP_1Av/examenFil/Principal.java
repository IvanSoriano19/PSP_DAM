// package ExamenPSP_1Av.examenFil;

// COMPILAR:
// $ javac -encoding ISO-8859-1 Principal.java

public class Principal {
	public static void main(String[] args) {
		Mesa mesa = new Mesa();

		Filosofo p1 = new Filosofo(mesa, 1);
		Filosofo p2 = new Filosofo(mesa, 2);
		Filosofo p3 = new Filosofo(mesa, 3);
		Filosofo p4 = new Filosofo(mesa, 4);
		Filosofo p5 = new Filosofo(mesa, 5);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();

	}
}