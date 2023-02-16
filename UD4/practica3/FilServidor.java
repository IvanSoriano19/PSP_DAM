package practica3;
import java.io.*;
import java.net.*;
import java.util.*;

public class FilServidor extends Thread {

    BufferedReader fentrada;
    PrintWriter feixida;
    Socket socket = null;

    public FilServidor(Socket s) throws IOException {

        System.out.println("creamos fil servidor");
        socket = s;

        //creamos flujos de entrada y salida
        feixida = new PrintWriter(socket.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void run() {

        System.out.println("en fil: comunique amb : " + socket.toString());

        String cadena = "";

        boolean parar = false;
        ArrayList<String> lista = new ArrayList<String>();
        String cadenarec;

        while (!cadena.trim().equals("*") && !parar) {
            try {
                //aqui leemos la cadena
                cadenarec = fentrada.readLine();
                if (!cadenarec.contains("*")) {
                    //añadimos la cadena al arraylist
                    lista.add(cadenarec);
                    System.out.println("recibe " + cadenarec);

                } else {
                    //aqui lo ordenamos
                    Collections.sort(lista);
                    //enviamos el tamaño de la cadena
                    feixida.write(lista.size());
                    for (String string : lista) {
                        //enviamos la cadena
                        feixida.println(string+" ");
                    }
                    parar = true;
                }
            } catch (Exception e) {
                parar = true;
            }
        }

    }
}
