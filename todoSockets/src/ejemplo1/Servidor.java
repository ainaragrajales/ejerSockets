package ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    //primero hay que poner en marcha el servidor y luego el cliente

    //va a ser una clase ejecutable, necesita un Main
    public static void main(String[] args) throws IOException {

        //crear el serverSocket con solo el puerto
        ServerSocket servidor = new ServerSocket(6500);

        //se crea un socket en el servidor en el caso de que haya una petición del cliente
        Socket cli = servidor.accept();

        //generar el flujo de entrada, para leer lo que ha enviado el cliente
        DataInputStream datos = new DataInputStream(cli.getInputStream());
        System.out.println("\nLos datos recibidos son: --> " + datos.readUTF());

        //generar flujo de salida que se le envia al cliente
        DataOutputStream escribir = new DataOutputStream(cli.getOutputStream());
        escribir.writeUTF("\n --> Hola Cliente");

        //cerrar las conexiones
        datos.close();
        escribir.close();
        cli.close();
    }
}
