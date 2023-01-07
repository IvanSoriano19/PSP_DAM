package U4P2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Cliente {

    private Socket socket = null;
    private ObjectOutputStream ObjectOS = null;
    private  Scanner sc = new Scanner(System.in);

    private boolean estaConnectat = false;

    public void comunicar() {

        while (!estaConnectat) {
            try {
                // CONNECTE
                socket = new Socket("localhost", 4445);
                System.out.println("Connectat");
                estaConnectat = true;

                // ENVIAMENT
                // CREE EL FLUX D'EIXIDA
                ObjectOS = new ObjectOutputStream(socket.getOutputStream());

                // CARREGUE DADES EN OBJECTE


            }catch (SocketException se) {
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
