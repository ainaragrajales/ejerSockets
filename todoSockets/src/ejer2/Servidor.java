package ejer2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    //primero poner en marcha servidor y luego cliente

    public static void main(String[] args) throws IOException {

        //crear el serverSocket con solo el puerto
        ServerSocket servidor = new ServerSocket(6500);
        //se crea un socket en el servidor en el caso de que haya una petición del cliente
        Socket cli = servidor.accept();
        System.out.println("Servidor encendido\n");
        String mensaje;
        PrintWriter fsalida = new PrintWriter(cli.getOutputStream());
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(cli.getInputStream()));
        while ((mensaje=fentrada.readLine())!=null) {

            fsalida.println(mensaje.toUpperCase());
            System.out.println("Recibiendo      " + mensaje);

        }
        fentrada.close();
        fsalida.close();
        cli.close();
        servidor.close();

        System.out.println("Se terminó la conexion");


    }
}
