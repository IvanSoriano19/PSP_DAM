package UD2.vector;

public class Espacio {
    private int indice;
    private int valor;
    private char valorHilo;
    static int id = 0;

    public Espacio() {
        valor = id;
        valorHilo = ' ';
        id++;
    }

    public int getIndice() {
        return indice;
    }

    public int getValor() {
        return valor;
    }

    public char getValorHilo() {
        return valorHilo;
    }

    public void setValorHilo(char valorHilo, int valor) {
        this.valorHilo = valorHilo;
        this.valor = valor;
    }

}
