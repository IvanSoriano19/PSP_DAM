package practica4;

import java.io.*;
import java.net.*;
import java.util.*;

public class FilServidor extends Thread {

    InputStream auxentrada;
    OutputStream auxeixida;
    DataInputStream fentrada;
    DataOutputStream feixida;
    Socket socket = null;

    int maxLine;
    boolean positive;

    int suma;

    public FilServidor(Socket s) throws IOException {

        System.out.println("creamos fil servidor");
        socket = s;

        // ASSOCIE FLUX EIXIDA I ENTRADA DE DADES AL SOCKET DEL CLIENT
        auxentrada = socket.getInputStream();
        auxeixida = socket.getOutputStream();
        // ASSOCIE FLUX DE DADES A UN ALTRE FLUX TIPUS DataInputStream
        fentrada = new DataInputStream(auxentrada);
        feixida = new DataOutputStream(auxeixida);

        positive = false;
        suma = 0;
    }

    public void run() {

        numPos();

        System.out.println("en fil: comunique amb : " + socket.toString());

        ArrayList<String> lista = new ArrayList<String>();
        String cadenarec;
        try {

            for (int i = 0; i < maxLine; i++) {

                int suma = 0;
                // aqui leo la cadena
                cadenarec = fentrada.readUTF();

                for (int j = 0; j < cadenarec.length(); j++) {
                    char c = cadenarec.charAt(j);
                    suma += c;
                }
                // añadimos la cadena al arraylist

                String cadena = "recibe " + cadenarec + " y la suma es " + suma;
                lista.add(cadena);

                System.out.println(cadena);
            }

            // enviamos tamaño del array

            feixida.write(lista.size());

            for (String sumas : lista) {
                // enviamos la cadena
                feixida.writeUTF(sumas);
            }

        } catch (Exception e) {

        }
    }

    public void numPos() {
        while (!positive) {
            try {
                maxLine = fentrada.read(); // RECIBO CANTIDAD LINEAS

                if (maxLine > 0) {
                    positive = true;
                }

                feixida.writeBoolean(positive); // ENVIO SI REPITE O NO
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
