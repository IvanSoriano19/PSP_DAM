package practica2;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author abastos
 */
public class FilServer extends Thread {

    Socket socket = null;

    InputStream auxentrada;
    OutputStream auxeixida;
    DataInputStream entrada;
    DataOutputStream eixida;

    int maxLine;
    boolean positive;

    int suma;
    int[] total;

    public FilServer(Socket s) throws IOException {
        System.out.println("Cree Fil");
        socket = s;

        // ASSOCIE FLUX EIXIDA I ENTRADA DE DADES AL SOCKET DEL CLIENT
        auxentrada = socket.getInputStream();
        auxeixida = socket.getOutputStream();
        // ASSOCIE FLUX DE DADES A UN ALTRE FLUX TIPUS DataInputStream
        entrada = new DataInputStream(auxentrada);
        eixida = new DataOutputStream(auxeixida);

        // INICIALIZAMOS SUMA A 0 Y POSITIVE EN FALSE
        positive = false;
        suma = 0;
    }

    // LOGICA DEL SERVIDOR. ATENC EL CLIENT
    @Override
    public void run() {
        numPos(); // COMPRUEBO QUE ES UN NUMERO POSITIVO

        total = new int[maxLine];

        recibir(); // RECIBO CADENAS

        enviar(); // ENVIO SUMAS

        try {
            System.out.println("Fin conexion con " +socket.toString());
            socket.close(); // CIERRO SOCKET
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void numPos() {
        while (!positive) {
            try {
                maxLine = entrada.readInt(); //RECIBO CANTIDAD LINEAS

                if (maxLine > 0) {
                    positive = true;
                }

                eixida.writeBoolean(positive); //ENVIO SI REPITE O NO
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void recibir() {
        for (int i = 0; i < maxLine; i++) {
            try {
                String cadena = entrada.readUTF(); // RECIBO LA CADENA

                // RECORRO LA CADENA Y SUMO CARACTER A CARACTER
                for (int j = 0; j < cadena.length(); j++) {
                    char c = cadena.charAt(j);
                    suma += c;
                }

                total[i] = suma; // AÑADO EL TOTAL A UN ARRAY
                suma = 0;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void enviar() {
        for (int i = 0; i < maxLine; i++) {
            try {
                String cad = "La suma de la cadena " + (i + 1) + " es: " + total[i]; // ENVIO LAS SUMAS EN EL MISMO ORDEN QUE LLEGAN
                eixida.writeUTF(cad);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
