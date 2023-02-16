package practica4;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 60000);

            // creamos flujos de entrada y salida
            // ASSOCIE FLUX EIXIDA I ENTRADA DE DADES AL SOCKET DEL CLIENT
            InputStream auxentrada = socket.getInputStream();
            OutputStream auxeixida = socket.getOutputStream();
            // ASSOCIE FLUX DE DADES A UN ALTRE FLUX TIPUS DataInputStream
            DataInputStream fentrada = new DataInputStream(auxentrada);
            DataOutputStream feixida = new DataOutputStream(auxeixida);

            String cadena, nom;
            // String nom;
            int n, nCadenas;
            boolean positivo;
            System.out.println("Cuantas cadenas vas a pasarme?");
            nCadenas = sc.nextInt();
            do {
                feixida.write(nCadenas);

                positivo = fentrada.readBoolean();

                if (!positivo) {
                    System.out.println("Pon un numero positovo");
                    nCadenas = sc.nextInt();
                }

            } while (!positivo);

            do {
                System.out.println("Que quieres que te convierta a ascii");
                cadena = sc.nextLine();
                feixida.writeUTF(cadena);
                sc.nextLine();
                nCadenas--;
            } while (nCadenas == 0);
            
            // recibimos el tamaño del arrayList
            n = fentrada.read();
            System.out.println("hay " + n + " sumas");

            for (int i = 0; i < n; i++) {
                nom = fentrada.readUTF();
                System.out.println(nom);
            }

            feixida.close();
            fentrada.close();
            socket.close();

        } catch (Exception e) {
        }
    }
}
