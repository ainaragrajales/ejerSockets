package ejer1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    //primero hay que poner en marcha el servidor y luego el cliente

    public static void main(String[] args) throws IOException {

        //crear el serverSocket con solo el puerto
        ServerSocket servidor = new ServerSocket(6500);

        System.out.println("Servidor encendido\n");
        for (int i = 0; i < 5; i++) {

            //se crea un socket en el servidor en el caso de que haya una petición del cliente
            Socket cli = servidor.accept();

            //generar flujo de salida que se le envia al cliente
            DataOutputStream escribir = new DataOutputStream(cli.getOutputStream());

            System.out.println("Atendiendo al cliente " + (i+1));

            escribir.writeUTF("\n --> Hola Cliente " + (i+1));

            //cerrar las conexiones
            escribir.close();

            if (i == 4){
                System.out.println("\nNo se aceptan más conexiones, se ha lledago al límite de 5");
            }
        }


    }

}
