
//////////////////////////////////////////////////
// EJEMPLO DE CÓMO ORDENAR UNA LISTA DE CADENAS //
//////////////////////////////////////////////////

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
 
public class Main {
     
    public static void main(String[] args) {
        List<String> nombres = new LinkedList<String>();
        // Agregamos los nombres.
        nombres.add("Aries");
        nombres.add("Tauro");
        nombres.add("Geminis");
        nombres.add("Cancer");
        nombres.add("Leo");
        nombres.add("Virgo");
        nombres.add("Libra");
        nombres.add("Escorpio");
        nombres.add("Sagitario");
        nombres.add("Capricornio");
        nombres.add("Acuario");
        nombres.add("Piscis");
         
        // Ordenamos la lista.
        Collections.sort(nombres); 
         
        // Imprimimos
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        // El resultado seria: Acuario, Aries, Cancer, Capricornio, Escorpio, Geminis, Leo, Libra, Piscis, Sagitario, Tauro, Virgo. 
    }
}