package practica2;


import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author abastos
 */
public class Client {

    static Scanner n = new Scanner(System.in);
    static int l;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 60000)) {

            // ASSOCIE FLUX EIXIDA I ENTRADA DE DADES AL SOCKET DEL CLIENT
            InputStream auxentrada = socket.getInputStream();
            OutputStream auxeixida = socket.getOutputStream();
            // ASSOCIE FLUX DE DADES A UN ALTRE FLUX TIPUS DataInputStream
            DataInputStream entrada = new DataInputStream(auxentrada);
            DataOutputStream eixida = new DataOutputStream(auxeixida);

            // CADENAS A ENVIAR AL SERVER
            System.out.println("Cuantas lineas vas a enviar?");
            l = n.nextInt();

            // ENVIO LA CANTIDAD DE LINEAS
            boolean positive = false;
            do {
                eixida.writeInt(l);
                // COMPRUEBO QUE ES UN NUMERO POSITIVO
                positive = entrada.readBoolean();

                if (!positive) {
                    System.out.println("ERROR: Introduzca un numero positivo");
                    l = n.nextInt();
                }
            } while (!positive);

            n.nextLine();

            // ENVIO LAS CADENAS
            for (int i = 0; i < l; i++) {
                eixida.writeUTF(n.nextLine());
            }

            // RECIBO LAS SUMAS
            for (int i = 0; i < l; i++) {
                try {
                    System.out.println(entrada.readUTF());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            // TANQUE SOCKET
            socket.close();
        }
    }
}
