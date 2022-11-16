package UD2.filosofos;

public class Palillos {
    private boolean estado[];

    public Palillos(int numPalillos) {
        this.estado = new boolean[numPalillos];
    }

    public int palilloIzq(int filo) {
        return filo;
    }

    public int palilloDer(int filo) {
        if (filo == 0) {
            return estado.length - 1;
        } else {
            return filo - 1;
        }
    }

    public synchronized void cogerPalillos(int filo) {
        while (estado[palilloIzq(filo)] || estado[palilloDer(filo)]) {
            try {
                wait();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        estado[palilloIzq(filo)] = true;
        estado[palilloDer(filo)] = true;
    }

    public synchronized void dejarPalillos(int filo) {
        estado[palilloIzq(filo)] = false;
        estado[palilloDer(filo)] = false;
        notifyAll();
    }
}
