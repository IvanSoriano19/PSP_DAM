package UD2.titanic;

import java.util.*;

public class Hilo extends Thread{
    
    private ArrayList<Persona> lista_personas = new ArrayList<Persona>();

    public Hilo(String nombre, ArrayList<Persona> lista) {
        super(nombre);
        lista_personas = lista;
    }

    @Override
    public void run() {
        int cont1 = 0;
        int cont2 = 0;
        int cont3 = 0;
        int s1_s = 0;
        int s1_n = 0;
        int s2_s = 0;
        int s2_n = 0;
        int s3_s = 0;
        int s3_n = 0;

        for (Persona persona : lista_personas) {
            if (persona.getClase()==1) {
                cont1++;
                if (currentThread().getName().equals("Primera clase")) {
                    if (persona.getSobrevivido() == 'S') {
                        s1_s++;
                    }else{
                        s1_n++;
                    }
                }
            }
            if (persona.getClase()==2) {
                cont2++;
                if (currentThread().getName().equals("Segunda clase")) {
                    if (persona.getSobrevivido() == 'S') {
                        s2_s++;
                    }else{
                        s2_n++;
                    }
                }
            }
            if (persona.getClase()==3) {
                cont3++;
                if (currentThread().getName().equals("Tercera clase")) {
                    if (persona.getSobrevivido() == 'S') {
                        s3_s++;
                    }else{
                        s3_n++;
                    }
                }
            }
        }

        if (currentThread().getName().equals("Primera clase")) {

            float porcentajeVivo = ((float) s1_s/cont1)*100; 
            float porcentajeMuerto = ((float) s1_n/cont1)*100; 

            System.out.println("En primera clase viajaban "+cont1+" personas, solo han sobrevivido "+s1_s+" ("+porcentajeVivo+"%). Y han fallecido "+s1_n+" ("+porcentajeMuerto+"%)");
        }
        if (currentThread().getName().equals("Segunda clase")) {

            float porcentajeVivo = ((float) s2_s/cont2)*100; 
            float porcentajeMuerto = ((float) s2_n/cont2)*100; 

            System.out.println("En segunda clase viajaban "+cont2+" personas, solo han sobrevivido "+s2_s+" ("+porcentajeVivo+"%). Y han fallecido "+s2_n+" ("+porcentajeMuerto+"%)");
        }
        if (currentThread().getName().equals("Tercera clase")) {

            float porcentajeVivo = ((float) s3_s/cont3)*100; 
            float porcentajeMuerto = ((float) s3_n/cont3)*100; 

            System.out.println("En tercera clase viajaban "+cont3+" personas, solo han sobrevivido "+s3_s+" ("+porcentajeVivo+"%). Y han fallecido "+s3_n+" ("+porcentajeMuerto+"%)");
        }

    }

}
