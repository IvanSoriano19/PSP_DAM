package ExamenPSP_1Av.examenFil2;

import UD2.filosofos.Palillos;

public class Principal {
    public static void main(String[] args) {
        Palillo[] palillos = new Palillo[5];

        for (int i = 0; i < palillos.length; i++) {
            palillos[i] = new Palillo(i);
        }

        Filosofo[] filosofos = new Filosofo[5];

        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i] = new Filosofo(i, palillos[i],palillos[(i+1)%5]);
        }

        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i].start();
        }
    }
}
