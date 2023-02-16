package practica3;
import java.io.*;
import java.net.*;


public class Servidor {
    public static void main(String[] args) throws IOException {
        
        ServerSocket servidor;//creamos ServerSocket
        servidor = new ServerSocket(60000);
        
        System.out.println("inicio en el servidor en 60000");
        
        while (true) {            
            Socket socketClient = new Socket();
            socketClient = servidor.accept();
            FilServidor fil = new FilServidor(socketClient);
            fil.start();
            System.out.println("inicio del servidor");
        }
        
    }
}
