package UD2.ejercicios21;

import java.util.*;

public class Coche extends Thread{

    int num_coche;
    int avanzar;
    boolean parar;


    public Coche(int num, String marca) {
        super(marca);
        num_coche = num;
        parar = false;
        avanzar = 0;
        System.out.println("Se ha creado el coche "+marca+" que es el coche "+num_coche);
    }

    public void run() {
        Random rd = new Random();
        int num;
        while (!parar) {
            num = rd.nextInt()*100;
            avanzar += num;

            if (avanzar > 500) {
                parar = true;
            }else{
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println("El coche "+getName()+" ha recorrido "+avanzar+" KM");
            }


        }

        System.out.println("----------------------------------------------------");
        System.out.println("El coche "+getName()+" ha recorrido "+avanzar+" KM, por lo tanto ha acabado");

    }
}
