package practica2;

import java.io.*;
import java.net.*;

/**
 *
 * @author abastos
 */
public class Server {

    public static void main(String args[]) throws IOException {

        ServerSocket servidor; // CREE serverSocket
        servidor = new ServerSocket(60000);
        System.out.println("Inici Servidor en 60000");

        while (true) {
            Socket socketClient = new Socket();
            socketClient = servidor.accept(); // ESPERE AL CLIENT
            FilServer fil = new FilServer(socketClient); // FIL ATEN AL CLIENT
            fil.start(); // INICIE EL FIL
            System.out.println("Inici Fil");
        }

    }
}
