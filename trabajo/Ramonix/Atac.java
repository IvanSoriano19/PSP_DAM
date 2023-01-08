import java.net.*;
import java.io.*;

public class Atac extends Thread {

    public String name;
    Socket socket;
    public int PORT = Comu.PORT;
    public String HOST = Comu.HOST;

    public Atac(String nombre) {
        name = nombre;
    }

    public void run() {

        System.out.println("Empieza " + name);
        int damage, energia;
        try {
            //si es menor de 0 sale del bucle 
            do {
                socket = new Socket(HOST, PORT);
                //creo los flujos de entrada y de salida de datos
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                //recojo la energia que queda 
                energia = dataInputStream.readInt();
            
                if (energia > 0) {
                    if (name.equalsIgnoreCase("Ab4$t0$")) {
                        System.out.println(Comu.ANSI_CYAN + "Ataca " + name + Comu.ANSI_RESET);
                    } else {
                        System.out.println(Comu.ANSI_GREEN + "Ataca " + name + Comu.ANSI_RESET);
                    }
                    damage = damage(name);
                    //Aqui meto los datos en un string separado por un guion
                    //para cuando pase los datos poder separarlos mas comodo con un split
                    String str = damage + "-" + name;
                    dataOutputStream.writeUTF(str);
                    dataOutputStream.flush();
                    if (name.equalsIgnoreCase("Neo")) {
                        sleep(2000);
                    } else {
                        sleep(1000);
                    }
                }
            } while (energia > 0);
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    //en este metodo nos devuelve el daño que vamos a hacer, si es neo hará 20 de daño
    //sino siempre hara 10 ( en la clase Ramonix separa si suma o resta la energia )
    public static int damage(String nombre) {
        int damageCant = 10;
        if (nombre.equalsIgnoreCase("Neo")) {
            damageCant = 20;
        }
        return damageCant;
    }

}
