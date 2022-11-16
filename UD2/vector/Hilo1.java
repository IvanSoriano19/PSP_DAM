package UD2.vector;

import java.util.*;

public class Hilo1 extends Thread{

    private int max, min;
    private ArrayList<Espacio> vector;

    public Hilo1(String nombre, int max, int min, ArrayList<Espacio> vector) {
        super(nombre);
        this.max = max;
        this.min = min;
        this.vector = vector;
    }

    
    public void run() {
        int num;
        for (int i = 0; i < 10; i++) {
            try {
                sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            num  = min + ((int)Math.random() * max);  

            if (vector.get(i).getValorHilo() == ' ') {
                vector.get(i).setValorHilo('1', num);
            } else {
                break;
            }
                
            pintarTabla();
        }
        
    }


    public void pintarTabla(){
        for (int i = 0; i < 10; i++) {
            Espacio espacio = vector.get(i);
            System.out.print(espacio.getIndice()+"\t");
        }
        System.out.println("\n--------------------------------------------------------------------------\n");

        for (int i = 0; i < 10; i++) {
            Espacio espacio = vector.get(i);
            System.out.print(espacio.getValor()+"\t");
        }
        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            Espacio espacio = vector.get(i);
            System.out.print(espacio.getValorHilo()+"\t");
        }
        System.out.println("\n\n");
        
    }
}
