import java.net.*;
import java.io.*;

public class Ramonix extends Thread {

    public static void main(String[] arg) {
        new Ramonix().start();
    }

    private static int PORT = Comu.PORT;
    private static int energia = 200;

    public void run() {

        try {
            System.out.println("Port: " + PORT);

            ServerSocket serverSocket = new ServerSocket(PORT);

            // gestiona la conexion con los clientes
            while (energia > 0) {
                Socket socket = serverSocket.accept();

                // creamos flujos
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                // enviamos la energia 
                dataOutputStream.writeInt(energia);
                // recibimos y como nos llega un string lo partimos en 2 con split
                // el [0] es el daño que hace y el [1] el nombre
                String str = dataInputStream.readUTF();
                String[] partes = str.split("-");
                int damage = Integer.parseInt(partes[0]);
                String name = partes[1];

                contabilizarAtaques(damage, name);

            }

            System.out.println(Comu.ANSI_WHITE_BACKGROUND+Comu.ANSI_BLACK+"RAMONIX TANGO DOWN"+Comu.ANSI_RESET);

            serverSocket.close();

        } catch (Exception e) {

        }

    }

    //este metodo contabiliza cada ataque y los "separa", si es Ab4$t0$ recupera energia sumando
    //pero si no es resta energia
    public static void contabilizarAtaques(int damage, String nombre) {

        
        if (nombre.equalsIgnoreCase("Ab4$t0$")) {
            energia += damage;
            System.out.println(Comu.ANSI_CYAN + "Ataca " + nombre + Comu.ANSI_RESET);
            System.out.println(Comu.ANSI_RED + "Energia: " + energia + Comu.ANSI_RESET);
        } else {
            System.out.println(Comu.ANSI_GREEN + "Ataca " + nombre + Comu.ANSI_RESET);
            System.out.println(Comu.ANSI_RED + "Energia: " + energia + Comu.ANSI_RESET);
            energia -= damage;
        }

    }

}
