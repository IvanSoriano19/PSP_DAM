package practica3;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 60000);

            //creamos flujos de entrada y salida
            PrintWriter feixida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //creamos flujos de entrada por teclado
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String cadena, nom;
            int n;

            do {
                System.out.println("dime el nombre");
                cadena = in.readLine();
                feixida.println(cadena);
            } while (!(cadena.contentEquals("*")));
            //recibimos el tamaño del arrayList
            n = fentrada.read();

            for (int i = 0; i < n; i++) {
                nom = fentrada.readLine();
                System.out.print(nom +" ");
            }

            feixida.close();
            fentrada.close();
            in.close();
            socket.close();

        } catch (Exception e) {
        }
    }
}
